package com.limaila.limaila_weixin_service.base.message;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.BaseReqMessage;

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

    private static Map<String,Vector<AbstractMessageHandler>> vectorMap = new HashMap<>();

    private ThreadLocal<BaseReqMessage> reqMsgThreadLocal = new ThreadLocal<>();

    private MessageChaining(){}

    public static MessageChaining getInstance() {
        return new MessageChaining();
    }

    public void setBaseReqMessage(BaseReqMessage baseReqMessage) {
        reqMsgThreadLocal.set(baseReqMessage);
    }

    public BaseReqMessage getBaseReqMessage() {
        return reqMsgThreadLocal.get();
    }
}
