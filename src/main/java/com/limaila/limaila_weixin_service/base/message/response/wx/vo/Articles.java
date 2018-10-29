package com.limaila.limaila_weixin_service.base.message.response.wx.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@XStreamAlias(value = "item")
public class Articles {

    private String Title;

    private String Description;

    private String PicUrl;

    private String Url;
}
