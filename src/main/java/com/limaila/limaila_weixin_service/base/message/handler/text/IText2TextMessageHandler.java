package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;

public class IText2TextMessageHandler extends AbstractObject2TextMessageHadnler<TextWxReqMessage> {


    public IText2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(TextWxReqMessage textWxReqMessage) {
        return textWxReqMessage.getContent().contains("文字");
    }

    @Override
    public String businessHandler(TextWxReqMessage textWxReqMessage) {
        return "收到文字:" + textWxReqMessage.getContent();
    }

}
