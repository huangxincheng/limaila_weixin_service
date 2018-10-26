package com.limaila.limaila_weixin_service.base.message.handler.abstracts.text;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.TextRespMessage;

import java.util.Date;

public abstract class AbstractText2TextMessageHandler extends AbstractTextMessageHandler {
    public AbstractText2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public BaseRespMessage handler(TextWxReqMessage textReqMessage) {
        TextRespMessage baseRespMessage = new TextRespMessage();
        baseRespMessage.setCreateTime(new Date().getTime());
        baseRespMessage.setFromUserName(textReqMessage.getToUserName());
        baseRespMessage.setToUserName(textReqMessage.getFromUserName());
        baseRespMessage.setMsgType(WxReqMsgEnum.TEXT.val());
        baseRespMessage.setContent(this.businessHandler(textReqMessage));
        return baseRespMessage;
    }

    public abstract String businessHandler(TextWxReqMessage textReqMessage);
}
