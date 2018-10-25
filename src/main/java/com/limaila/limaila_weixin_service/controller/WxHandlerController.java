package com.limaila.limaila_weixin_service.controller;

import com.limaila.limaila_weixin_service.helper.wxAppServer.WxAppServerHelper;
import com.limaila.limaila_weixin_service.helper.wxAppServer.WxSignHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/wxHandler")
public class WxHandlerController {

    @Autowired
    private WxAppServerHelper wxAppServerHelper;

    private static final Logger logger = LoggerFactory.getLogger(WxHandlerController.class);

    @RequestMapping
    public void handlerWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；boolean isGet =
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
        logger.info("============== 微信统一处理接口 ===============");
        try {
            if (wxAppServerHelper.getWxAppServer(wxKey) == null) {
                throw new RuntimeException("请求非法");
            }
            boolean check = WxSignHelper.checkSignature(wxAppServerHelper.getWxAppServer(wxKey).getAppToken(), signature, timestamp, nonce);
            if (check) {
                // 注意此处必须返回echostr以完成验证
                out.write(echostr);
            }
        } finally {
            out.close();
        }
    }
}
