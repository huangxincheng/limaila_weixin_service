package com.limaila.limaila_weixin_service.base.message.request;

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
public class TextReqMessage extends BaseReqMessage {

    private String Content;

}
