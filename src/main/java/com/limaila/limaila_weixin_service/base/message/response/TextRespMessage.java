package com.limaila.limaila_weixin_service.base.message.response;

import lombok.*;

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
public class TextRespMessage extends BaseRespMessage {

    private String Content;
}
