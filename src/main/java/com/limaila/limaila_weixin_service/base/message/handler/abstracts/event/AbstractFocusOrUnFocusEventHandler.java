package com.limaila.limaila_weixin_service.base.message.handler.abstracts.event;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.BaseReqEvent;
import com.limaila.limaila_weixin_service.base.message.request.FocusOrUnFocusReqEvent;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;

public abstract class AbstractFocusOrUnFocusEventHandler extends AbstractMessageHandler<FocusOrUnFocusReqEvent, BaseRespMessage> {
    public AbstractFocusOrUnFocusEventHandler(String key) {
        super(key);
    }
}
