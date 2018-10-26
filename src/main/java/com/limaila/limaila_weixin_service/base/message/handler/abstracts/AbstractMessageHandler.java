package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.message.request.BaseReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;

public abstract class AbstractMessageHandler<T extends BaseReqMessage,F extends BaseRespMessage> {

    private String key;

    public AbstractMessageHandler(String key) {
        this.key = key;
    }

    public abstract boolean isHandler(T t);

    public abstract F  handler(T t);

    protected AbstractMessageHandler nextHandler;

    public void setNextHandler(AbstractMessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
