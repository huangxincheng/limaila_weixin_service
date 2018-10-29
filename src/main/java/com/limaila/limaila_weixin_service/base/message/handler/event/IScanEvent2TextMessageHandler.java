package com.limaila.limaila_weixin_service.base.message.handler.event;

import com.limaila.limaila_weixin_service.base.enums.WxEventEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.event.ScanEvent;
import org.springframework.util.StringUtils;

public class IScanEvent2TextMessageHandler extends AbstractObject2TextMessageHadnler<ScanEvent> {

    public IScanEvent2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(ScanEvent scanEvent) {
        return "谢谢你扫码关注哦";
    }

    @Override
    public boolean isHandler(ScanEvent scanEvent) {
        return StringUtils.pathEquals(scanEvent.getEvent(), WxEventEnum.SCAN.name());
    }
}
