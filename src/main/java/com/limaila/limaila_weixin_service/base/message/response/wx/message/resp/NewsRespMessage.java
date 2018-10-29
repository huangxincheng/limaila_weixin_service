package com.limaila.limaila_weixin_service.base.message.response.wx.message.resp;

import com.limaila.limaila_weixin_service.base.message.response.wx.vo.Articles;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NewsRespMessage extends BaseRespMessage {

    private Integer ArticleCount;

    private Articles item;
}
