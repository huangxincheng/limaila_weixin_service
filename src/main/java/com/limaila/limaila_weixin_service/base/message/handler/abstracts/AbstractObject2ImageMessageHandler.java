package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.ImageRespMessage;

import java.util.Date;

public abstract class AbstractObject2ImageMessageHandler<T extends BaseWxReq>  extends AbstractMessageHandler<T, BaseRespMessage> {

    public AbstractObject2ImageMessageHandler(String key) {
        super(key);
    }

    public abstract String businessHandler(T t);

    @Override
    public BaseRespMessage handler(T t) {
        ImageRespMessage respMessage = new ImageRespMessage();
        respMessage.setCreateTime(new Date().getTime());
        respMessage.setFromUserName(t.getToUserName());
        respMessage.setToUserName(t.getFromUserName());
        respMessage.setMsgType(WxReqMsgEnum.IMAGE.val());
        respMessage.setMediaId(this.businessHandler(t));
        return respMessage;
    }
}
