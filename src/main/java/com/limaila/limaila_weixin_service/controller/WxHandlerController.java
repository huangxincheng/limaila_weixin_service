package com.limaila.limaila_weixin_service.controller;

import com.alibaba.fastjson.JSON;
import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.MessageChaining;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.request.event.ScanEvent;
import com.limaila.limaila_weixin_service.base.message.request.event.SubscribeEvent;
import com.limaila.limaila_weixin_service.base.message.request.event.UnSubscribeEvent;
import com.limaila.limaila_weixin_service.base.message.request.message.BaseWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.BaseRespMessage;
import com.limaila.limaila_weixin_service.constant.SystemConstant;
import com.limaila.limaila_weixin_service.helper.base.XmlHelper;
import com.limaila.limaila_weixin_service.helper.wxAppServer.WxAppServerHelper;
import com.limaila.limaila_weixin_service.helper.wxAppServer.WxSignHelper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/wxHandler")
public class WxHandlerController {

    @Autowired
    private WxAppServerHelper wxAppServerHelper;

    private static final Logger logger = LoggerFactory.getLogger(WxHandlerController.class);

    @RequestMapping
    public void handlerWeixin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding(SystemConstant.defaultUTF8Character);  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding(SystemConstant.defaultUTF8Character); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；boolean isGet =
        PrintWriter out = response.getWriter();
        String signature = request.getParameter("signature"); // 微信加密签名
        String timestamp = request.getParameter("timestamp"); // 时间戳
        String nonce = request.getParameter("nonce");         // 随机数
        String echostr = request.getParameter("echostr");     // 随机字符串
        String wxKey = request.getParameter("wxKey");         // 区分那个公众号标识
        logger.info("============== 微信统一处理接口 ===============");
        logger.info(" signature = " + signature);
        logger.info(" timestamp = " + timestamp);
        logger.info(" nonce = " + nonce);
        logger.info(" echostr = " + echostr);
        logger.info(" wxKey = " + wxKey);
        logger.info(" method = " + request.getMethod());
        logger.info("============== 微信统一处理接口 ===============");
        if (wxAppServerHelper.getWxAppServer(wxKey) == null) {
            throw new RuntimeException("请求非法");
        }
        try {
            if (StringUtils.pathEquals(request.getMethod(), RequestMethod.GET.name())) {
                // 处理微信信息校验
                boolean check = WxSignHelper.checkSignature(wxAppServerHelper.getWxAppServer(wxKey).getAppToken(), signature, timestamp, nonce);
                if (check) {
                    // 注意此处必须返回echostr以完成验证
                    out.write(echostr);
                }
            } else if (StringUtils.pathEquals(request.getMethod(), RequestMethod.POST.name())) {
                // 处理微信发送过来的信息
                String inputStreamStr = IOUtils.toString(request.getInputStream());
                logger.info("==============微信请求inputStreamStr = \n{}", inputStreamStr);
                Map<String, String> requestMap = XmlHelper.xmlToMap(inputStreamStr);
                MessageChaining.setReqMsgMap(requestMap);
                logger.info("==============requestMap = \n{}", JSON.toJSONString(requestMap));
                if (StringUtils.pathEquals(requestMap.get("MsgType"), WxReqMsgEnum.TEXT.val())) {
                    // 将XML转换成实体对象
                    BaseWxReq baseReqMessage = XmlHelper.toBeanWithCData(inputStreamStr, TextWxReqMessage.class);
                    // 存入线程
                    MessageChaining.setBaseReqMessage(baseReqMessage);
                    BaseRespMessage baseRespMessage = MessageChaining.traverseTextHandler(wxKey);
                    if (baseRespMessage == null) {
                        logger.info("==============服务响应微信文本请求 baseRespMessage = \n{}", "success");
                        out.write("success");
                    } else {
                        String responseStr = XmlHelper.toXmlWithCData(baseRespMessage);
                        logger.info("==============服务响应微信文本请求 baseRespMessage = \n{}", responseStr);
                        out.write(responseStr);
                    }
                }
                else if (StringUtils.pathEquals(requestMap.get("MsgType"), WxReqMsgEnum.EVENT.val())) {
                    if (StringUtils.pathEquals(requestMap.get("Event"), WxEventEnum.subscribe.name())) {
                        BaseWxReq baseReqMessage = XmlHelper.toBeanWithCData(inputStreamStr, SubscribeEvent.class);
                        MessageChaining.setBaseReqMessage(baseReqMessage);
                    } else if(StringUtils.pathEquals(requestMap.get("Event"), WxEventEnum.unsubscribe.name())) {
                        BaseWxReq baseReqMessage = XmlHelper.toBeanWithCData(inputStreamStr, UnSubscribeEvent.class);
                        MessageChaining.setBaseReqMessage(baseReqMessage);
                    } else if(StringUtils.pathEquals(requestMap.get("Event"), WxEventEnum.SCAN.name())) {
                        BaseWxReq baseReqMessage = XmlHelper.toBeanWithCData(inputStreamStr, ScanEvent.class);
                        MessageChaining.setBaseReqMessage(baseReqMessage);
                    }
                    BaseRespMessage baseRespMessage = MessageChaining.traverseEventHandler(wxKey);
                    if (baseRespMessage == null) {
                        logger.info("==============服务响应微信事件请求 baseRespMessage = \n{}", "success");
                        out.write("success");
                    } else {
                        String responseStr = XmlHelper.toXmlWithCData(baseRespMessage);
                        logger.info("==============服务响应微信事件请求 baseRespMessage = \n{}", responseStr);
                        out.write(responseStr);
                    }
                } else {
                    //其他类型直接返回success（自己扩展）
                    logger.info("===============服务响应微信{}请求 baseRespMessage = \n{}", requestMap.get("MsgType"), "success");
                    out.write("success");
                }
            }
        } finally {
            MessageChaining.removeBaseReqMessage();
            MessageChaining.removeReqMsgMap();
            out.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String xmlStr = "<xml><ToUserName><![CDATA[gh_315261d1c925]]></ToUserName>" +
                "<FromUserName><![CDATA[o6heKxP38ntqKaLDrE0ZsU80G03E]]></FromUserName>" +
                "<CreateTime>1540535388</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[1]]></Content>" +
                "<MsgId>6616549110471337329</MsgId>" +
                "</xml>";
        Map<String, String> stringStringMap = XmlHelper.xmlToMap(xmlStr);
        String s = JSON.toJSONString(stringStringMap);
        System.out.println(s);
    }
}
