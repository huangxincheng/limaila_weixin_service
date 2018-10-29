package com.limaila.limaila_weixin_service.base.message.handler.abstracts.event;

import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.event.SubscribeEvent;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import org.springframework.util.StringUtils;

abstract class AbstractSubscribeEventMessageHandler extends AbstractMessageHandler<SubscribeEvent, BaseRespMessage> {

    AbstractSubscribeEventMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(SubscribeEvent subscribeEvent) {
        boolean flag = StringUtils.pathEquals(subscribeEvent.getMsgType(), WxReqMsgEnum.EVENT.val());
        boolean eventFlag = StringUtils.pathEquals(subscribeEvent.getEvent(), WxEventEnum.subscribe.name());
        if (flag && eventFlag) {
            return isBusinessHandler(subscribeEvent);
        }
        return false;
    }

    abstract boolean isBusinessHandler(SubscribeEvent subscribeEvent);
}
