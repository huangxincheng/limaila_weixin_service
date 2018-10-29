package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2ImageMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;

public class IText2ImageMessageHandler extends AbstractObject2ImageMessageHandler<TextWxReqMessage> {

    public IText2ImageMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(TextWxReqMessage textWxReqMessage) {
        return textWxReqMessage.getContent().contains("图片");
    }

    @Override
    public String businessHandler(TextWxReqMessage textWxReqMessage) {
        return "meidaid";
    }
}
