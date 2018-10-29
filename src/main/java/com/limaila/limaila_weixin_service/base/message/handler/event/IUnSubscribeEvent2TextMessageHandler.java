package com.limaila.limaila_weixin_service.base.message.handler.event;

import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.event.UnSubscribeEvent;
import org.springframework.util.StringUtils;

public class IUnSubscribeEvent2TextMessageHandler extends AbstractObject2TextMessageHadnler<UnSubscribeEvent> {

    public IUnSubscribeEvent2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(UnSubscribeEvent unSubscribeEvent) {
        return "谢谢你的取消关注";
    }

    @Override
    public boolean isHandler(UnSubscribeEvent unSubscribeEvent) {
        return StringUtils.pathEquals(unSubscribeEvent.getEvent(), WxEventEnum.unsubscribe.name());
    }
}
