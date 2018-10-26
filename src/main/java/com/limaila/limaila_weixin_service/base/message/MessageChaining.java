package com.limaila.limaila_weixin_service.base.message;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.text.ITextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.BaseReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServerKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Author: huangxincheng
 * 消息链
 *  1.线程存放需要处理的消息
 *  2.vectors存放各个消息处理
 * <p>
 * <p>
 **/
public class MessageChaining {

    private static Map<String,Vector<AbstractMessageHandler>> handlerMap = new HashMap<>();

    static {
        Vector<AbstractMessageHandler> vector = new Vector<>();
        vector.add(new ITextMessageHandler(WxAppServerKey.LIMAILA));
        handlerMap.put(WxAppServerKey.LIMAILA, vector);
    }

    private static final ThreadLocal<BaseReqMessage> reqMsgThreadLocal = new ThreadLocal<>();

    private MessageChaining(){}

    public static MessageChaining getInstance() {
        return new MessageChaining();
    }

    public static  void setBaseReqMessage(BaseReqMessage baseReqMessage) {
        reqMsgThreadLocal.set(baseReqMessage);
    }

    public static BaseReqMessage getBaseReqMessage() {
        return reqMsgThreadLocal.get();
    }

    public static BaseRespMessage traverseHandler(String key) {
        Vector<AbstractMessageHandler> vector = handlerMap.get(key);
        for (AbstractMessageHandler abstractMessageHandler : vector) {
            if (abstractMessageHandler.isHandler(reqMsgThreadLocal.get())) {
                return abstractMessageHandler.handler(reqMsgThreadLocal.get());
            }
        }
        return null;
    }
}
