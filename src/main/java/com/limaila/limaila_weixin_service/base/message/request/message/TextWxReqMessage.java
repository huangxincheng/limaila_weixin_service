package com.limaila.limaila_weixin_service.base.message.request.message;

import lombok.*;

/**
 * 文本消息
 * Author: huangxincheng
 * <p>
 * <p>
 **/
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TextWxReqMessage extends BaseWxReqMessage {

    private String Content;

}
