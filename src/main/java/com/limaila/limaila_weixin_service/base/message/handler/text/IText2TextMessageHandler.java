package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractText2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.TextReqMessage;

public class IText2TextMessageHandler extends AbstractText2TextMessageHandler {


    public IText2TextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(TextReqMessage textReqMessage) {
        return "收到消息:" + textReqMessage.getContent() + "\n" + "回复类型:文字";
    }

    @Override
    public boolean isBusinessHandler(TextReqMessage textRespMessage) {
       return textRespMessage.getContent().contains("文字");
    }
}