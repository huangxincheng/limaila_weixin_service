package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;

public abstract class AbstractMessageHandler<T extends BaseWxReq,F extends BaseRespMessage> {

    private String key;

    public AbstractMessageHandler(String key) {
        this.key = key;
    }

    public abstract boolean isHandler(T t);

    public abstract F  handler(T t);

}
