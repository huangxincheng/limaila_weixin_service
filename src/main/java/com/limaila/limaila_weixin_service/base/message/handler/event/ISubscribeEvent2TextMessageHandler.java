package com.limaila.limaila_weixin_service.base.message.handler.event;

import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.event.SubscribeEvent;
import org.springframework.util.StringUtils;

public class ISubscribeEvent2TextMessageHandler extends AbstractObject2TextMessageHadnler<SubscribeEvent> {

    public ISubscribeEvent2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(SubscribeEvent subscribeEvent) {
        return "谢谢你的关注";
    }

    @Override
    public boolean isHandler(SubscribeEvent subscribeEvent) {
        return StringUtils.pathEquals(subscribeEvent.getEvent(), WxEventEnum.subscribe.name());
    }
}
