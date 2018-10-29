package com.limaila.limaila_weixin_service.base.message.response.wx.message.resp;


import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ImageRespMessage extends BaseRespMessage {

    private String MediaId;
}
