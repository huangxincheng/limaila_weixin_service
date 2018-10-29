package com.limaila.limaila_weixin_service.base.message.response.wx.message.resp;

import com.limaila.limaila_weixin_service.base.message.response.wx.vo.Articles;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NewsRespMessage extends BaseRespMessage {

    private Integer ArticleCount;

    private List<Articles> item;
}
