package com.limaila.limaila_weixin_service.base.message.request;

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
public class BaseReqMessage extends BaseReq {

    //消息ID，64位整型
    private Long MsgId;
}
