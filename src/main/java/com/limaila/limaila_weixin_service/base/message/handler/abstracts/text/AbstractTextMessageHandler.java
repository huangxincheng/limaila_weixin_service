package com.limaila.limaila_weixin_service.base.message.handler.abstracts.text;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import org.springframework.util.StringUtils;

abstract class AbstractTextMessageHandler extends AbstractMessageHandler<TextWxReqMessage, BaseRespMessage> {

    AbstractTextMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(TextWxReqMessage textReqMessage) {
        boolean flag = StringUtils.pathEquals(textReqMessage.getMsgType(), WxReqMsgEnum.TEXT.val());
        if (flag) {
            return isBusinessHandler(textReqMessage);
        }
        return false;
    }

    public abstract boolean isBusinessHandler(TextWxReqMessage textRespMessage);
}
