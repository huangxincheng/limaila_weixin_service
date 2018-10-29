package com.limaila.limaila_weixin_service.base.message;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.event.IScanEvent2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.event.ISubscribeEvent2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.event.IUnSubscribeEvent2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.IText2ImageMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.IText2NewsMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.IText2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.BaseRespMessage;
import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServerKey;

import java.util.*;

/**
 * Author: huangxincheng
 * 消息链
 *  1.线程存放需要处理的消息
 *  2.vectors存放各个消息处理
 * <p>
 * <p>
 **/
public class MessageChaining {


    private static Map<String, List<AbstractMessageHandler>> TextReqHandlerMap = new HashMap<>();

    private static Map<String, List<AbstractMessageHandler>> EventReqHandlerMap = new HashMap<>();


    static {
        List<AbstractMessageHandler> TextList = new ArrayList<>();
        TextList.add(new IText2TextMessageHandler(WxAppServerKey.LIMAILA));
        TextList.add(new IText2ImageMessageHandler(WxAppServerKey.LIMAILA));
        TextList.add(new IText2NewsMessageHandler(WxAppServerKey.LIMAILA));
        TextReqHandlerMap.put(WxAppServerKey.LIMAILA, TextList);

        List<AbstractMessageHandler> EventList = new ArrayList<>();
        EventList.add(new ISubscribeEvent2TextMessageHandler(WxAppServerKey.LIMAILA));
        EventList.add(new IUnSubscribeEvent2TextMessageHandler(WxAppServerKey.LIMAILA));
        EventList.add(new IScanEvent2TextMessageHandler(WxAppServerKey.LIMAILA));
        EventReqHandlerMap.put(WxAppServerKey.LIMAILA, EventList);
    }

    private static final ThreadLocal<BaseWxReq> reqMsgThreadLocal = new ThreadLocal<>();

    private MessageChaining(){}

    public static MessageChaining getInstance() {
        return new MessageChaining();
    }

    public static  void setBaseReqMessage(BaseWxReq baseWxReq) {
        reqMsgThreadLocal.set(baseWxReq);
    }

    public static BaseWxReq getBaseReqMessage() {
        return reqMsgThreadLocal.get();
    }

    public static void removeBaseReqMessage() {
        reqMsgThreadLocal.remove();
    }


    public static BaseRespMessage traverseTextHandler(String key) {
        List<AbstractMessageHandler> list = TextReqHandlerMap.get(key);
        for (AbstractMessageHandler abstractMessageHandler : list) {
            if (abstractMessageHandler.isHandler(reqMsgThreadLocal.get())) {
                return abstractMessageHandler.handler(reqMsgThreadLocal.get());
            }
        }
        return null;
    }

    public static BaseRespMessage traverseEventHandler(String key) {
        List<AbstractMessageHandler> list = EventReqHandlerMap.get(key);
        for (AbstractMessageHandler abstractMessageHandler : list) {
            if (abstractMessageHandler.isHandler(reqMsgThreadLocal.get())) {
                return abstractMessageHandler.handler(reqMsgThreadLocal.get());
            }
        }
        return null;
    }
}
