package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractText2TextMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.TextReqMessage;
import org.springframework.util.StringUtils;

public class ITextMessageHandler extends AbstractText2TextMessageHandler {


    public ITextMessageHandler(String key) {
        super(key);
    }

    @Override
    public String businessHandler(TextReqMessage textReqMessage) {
        return "456";
    }

    @Override
    public boolean isBusinessHandler(TextReqMessage textRespMessage) {
        return StringUtils.pathEquals(textRespMessage.getContent(),"123");
    }
}
