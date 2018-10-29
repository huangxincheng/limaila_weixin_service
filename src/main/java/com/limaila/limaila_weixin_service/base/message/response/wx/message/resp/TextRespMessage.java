package com.limaila.limaila_weixin_service.base.message.response.wx.message.resp;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TextRespMessage extends BaseRespMessage {

    private String Content;
}
