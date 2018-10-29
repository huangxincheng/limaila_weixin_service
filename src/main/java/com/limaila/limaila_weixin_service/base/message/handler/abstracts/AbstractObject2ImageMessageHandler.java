package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.ImageRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.TextRespMessage;
import org.springframework.util.StringUtils;

import java.util.Date;

public abstract class AbstractObject2ImageMessageHandler<T extends BaseWxReq>  extends AbstractMessageHandler<T, BaseRespMessage> {

    public AbstractObject2ImageMessageHandler(String key) {
        super(key);
    }

    public abstract boolean isHandler(T t);

    public abstract boolean isBusinessHandler(T t);

    public abstract String businessHandler(T t);

    @Override
    public BaseRespMessage handler(T t) {
        TextRespMessage baseRespMessage = new TextRespMessage();
        baseRespMessage.setCreateTime(new Date().getTime());
        baseRespMessage.setFromUserName(t.getToUserName());
        baseRespMessage.setToUserName(t.getFromUserName());
        baseRespMessage.setMsgType(WxReqMsgEnum.IMAGE.val());
        baseRespMessage.setContent(this.businessHandler(t));
        return baseRespMessage;
    }
}
