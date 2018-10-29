package com.limaila.limaila_weixin_service.base.message;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.IText2ImageMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.IText2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.BaseWxReqMessage;
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
        List<AbstractMessageHandler> list = new ArrayList<>();
        list.add(new IText2TextMessageHandler(WxAppServerKey.LIMAILA));
        list.add(new IText2ImageMessageHandler(WxAppServerKey.LIMAILA));
        TextReqHandlerMap.put(WxAppServerKey.LIMAILA, list);
    }

    private static final ThreadLocal<BaseWxReqMessage> reqMsgThreadLocal = new ThreadLocal<>();

    private MessageChaining(){}

    public static MessageChaining getInstance() {
        return new MessageChaining();
    }

    public static  void setBaseReqMessage(BaseWxReqMessage baseReqMessage) {
        reqMsgThreadLocal.set(baseReqMessage);
    }

    public static BaseWxReqMessage getBaseReqMessage() {
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
