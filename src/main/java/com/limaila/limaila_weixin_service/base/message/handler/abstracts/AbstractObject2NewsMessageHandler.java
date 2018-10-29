package com.limaila.limaila_weixin_service.base.message.handler.abstracts;

import com.limaila.limaila_weixin_service.base.enums.WxRespMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.BaseRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.message.resp.NewsRespMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.vo.Articles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractObject2NewsMessageHandler<T extends BaseWxReq> extends AbstractMessageHandler<T, BaseRespMessage> {
    public AbstractObject2NewsMessageHandler(String key) {
        super(key);
    }

    public abstract Articles businessHandler(T t);

    @Override
    public BaseRespMessage handler(T t) {
        Articles articles = this.businessHandler(t);
        List<Articles> item = new ArrayList<>();
        item.add(articles);
        return new NewsRespMessage()
               .setArticleCount(1)
               .setArticles(item)
               .setCreateTime(new Date().getTime())
               .setFromUserName(t.getToUserName())
               .setToUserName(t.getFromUserName())
               .setMsgType(WxRespMsgEnum.news.name());
    }
}
