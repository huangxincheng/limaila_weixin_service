package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.text.AbstractText2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;

public class IText2TextMessageHandler extends AbstractText2TextMessageHandler {


    public IText2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(TextWxReqMessage textReqMessage) {
        return "收到文字:" + textReqMessage.getContent();
    }

    @Override
    public boolean isBusinessHandler(TextWxReqMessage textRespMessage) {
       return textRespMessage.getContent().contains("文字");
    }
}
