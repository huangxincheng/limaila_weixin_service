package com.limaila.limaila_weixin_service.base.message.handler.abstracts.event;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.event.BaseWxReqEvent;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import org.springframework.util.StringUtils;

abstract class AbstractEventMessageHandler extends AbstractMessageHandler<BaseWxReqEvent, BaseRespMessage> {


    AbstractEventMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(BaseWxReqEvent baseWxReqEvent) {
        boolean flag = StringUtils.pathEquals(baseWxReqEvent.getMsgType(), WxReqMsgEnum.EVENT.val());
        if (flag) {
            return isBusinessHandler(baseWxReqEvent);
        }
        return false;
    }

    public abstract boolean isBusinessHandler(BaseWxReqEvent baseWxReqEvent);
}
