package com.limaila.limaila_weixin_service.base.message.handler.abstracts.text;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.TextReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.ImageRespMessage;

import java.util.Date;

public abstract class AbstractText2ImageMessageHandler extends AbstractTextMessageHandler {

    public AbstractText2ImageMessageHandler(String key) {
        super(key);
    }

    @Override
    public BaseRespMessage handler(TextReqMessage textReqMessage) {
        ImageRespMessage baseRespMessage = new ImageRespMessage();
        baseRespMessage.setCreateTime(new Date().getTime());
        baseRespMessage.setFromUserName(textReqMessage.getToUserName());
        baseRespMessage.setToUserName(textReqMessage.getFromUserName());
        baseRespMessage.setMsgType(WxReqMsgEnum.TEXT.val());
        baseRespMessage.setMediaId(this.businessHandler(textReqMessage));
        return baseRespMessage;
    }

    public abstract String businessHandler(TextReqMessage textReqMessage);
}
