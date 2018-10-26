package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.text.AbstractText2ImageMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;

public class IText2ImageMessageHandler extends AbstractText2ImageMessageHandler {

    public IText2ImageMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(TextWxReqMessage textReqMessage) {
        return "meidaid";
    }

    @Override
    public boolean isBusinessHandler(TextWxReqMessage textRespMessage) {
        return textRespMessage.getContent().contains("图片");
    }
}
