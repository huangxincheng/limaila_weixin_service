package com.limaila.limaila_weixin_service.base.message.handler.abstracts.event;

import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.event.SubscribeEvent;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import org.springframework.util.StringUtils;

public class AbstractSubscribeEvent2TextMessageHandler extends AbstractObject2TextMessageHadnler<SubscribeEvent> {

    public AbstractSubscribeEvent2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(SubscribeEvent subscribeEvent) {
        return false;
    }

    @Override
    public String businessHandler(SubscribeEvent subscribeEvent) {
        return null;
    }
}
