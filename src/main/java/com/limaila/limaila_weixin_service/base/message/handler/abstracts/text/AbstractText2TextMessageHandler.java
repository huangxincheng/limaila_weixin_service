package com.limaila.limaila_weixin_service.base.message.handler.abstracts.text;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2TextMessageHadnler;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.TextRespMessage;
import org.springframework.util.StringUtils;

import java.util.Date;

public abstract class AbstractText2TextMessageHandler extends AbstractObject2TextMessageHadnler<TextWxReqMessage> {
    public AbstractText2TextMessageHandler(String key) {
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
