package com.limaila.limaila_weixin_service.base.message.handler.abstracts.text;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2ImageMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.ImageRespMessage;
import org.springframework.util.StringUtils;

import java.util.Date;

public abstract class AbstractText2ImageMessageHandler extends AbstractObject2ImageMessageHandler<TextWxReqMessage> {

    public AbstractText2ImageMessageHandler(String key) {
        super(key);
    }

    @Override
    public boolean isHandler(TextWxReqMessage textWxReqMessage) {
        boolean flag = StringUtils.pathEquals(textWxReqMessage.getMsgType(), WxReqMsgEnum.TEXT.val());
        if (flag) {
            return isBusinessHandler(textWxReqMessage);
        }
        return false;
    }
}
