package com.limaila.limaila_weixin_service.base.message.response.wx.vo;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Articles {

    private String Title;

    private String Description;

    private String PicUrl;

    private String Url;
}
