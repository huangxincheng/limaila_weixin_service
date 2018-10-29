package com.limaila.limaila_weixin_service.base.message.handler.text;

import com.limaila.limaila_weixin_service.base.message.handler.abstracts.AbstractObject2NewsMessageHandler;
import com.limaila.limaila_weixin_service.base.message.request.message.TextWxReqMessage;
import com.limaila.limaila_weixin_service.base.message.response.wx.vo.Articles;
import org.springframework.util.StringUtils;

public class IText2NewsMessageHandler extends AbstractObject2NewsMessageHandler<TextWxReqMessage> {

    public IText2NewsMessageHandler(String key) {
        super(key);
    }

    @Override
    public Articles businessHandler(TextWxReqMessage textWxReqMessage) {
        return new Articles().setTitle("title")
                .setDescription("description")
                .setUrl("http://www.baidu.com")
                .setPicUrl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3017052414,1295894805&fm=173&app=25&f=JPEG?w=218&h=146&s=FE906C8D5402F2E552B9C0690300F013");
    }

    @Override
    public boolean isHandler(TextWxReqMessage textWxReqMessage) {
        return StringUtils.pathEquals("图文", textWxReqMessage.getContent());
    }
}
