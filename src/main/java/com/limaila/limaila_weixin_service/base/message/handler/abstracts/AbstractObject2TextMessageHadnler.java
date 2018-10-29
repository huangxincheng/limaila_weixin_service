package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.enums.WxRespMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.TextRespMessage;

import java.util.Date;

public abstract class AbstractObject2TextMessageHadnler<T extends BaseWxReq>  extends AbstractMessageHandler<T, BaseRespMessage> {

    public AbstractObject2TextMessageHadnler(String key) {
        super(key);
    }

    public abstract String businessHandler(T t);

    @Override
    public BaseRespMessage handler(T t) {
       return new TextRespMessage().setContent(this.businessHandler(t))
                .setCreateTime(new Date().getTime())
                .setFromUserName(t.getToUserName())
                .setToUserName(t.getFromUserName())
                .setMsgType(WxRespMsgEnum.text.name());
    }
}
