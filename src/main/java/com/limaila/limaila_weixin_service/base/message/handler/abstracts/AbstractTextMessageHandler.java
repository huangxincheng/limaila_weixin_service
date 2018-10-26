package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.TextReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import org.springframework.util.StringUtils;

abstract class AbstractTextMessageHandler extends AbstractMessageHandler<TextReqMessage, BaseRespMessage> {

    AbstractTextMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(TextReqMessage textReqMessage) {
        boolean flag = StringUtils.pathEquals(textReqMessage.getMsgType(), WxReqMsgEnum.TEXT.val());
        if (flag) {
            return isBusinessHandler(textReqMessage);
        }
        return false;
    }

    public abstract boolean isBusinessHandler(TextReqMessage textRespMessage);
}
