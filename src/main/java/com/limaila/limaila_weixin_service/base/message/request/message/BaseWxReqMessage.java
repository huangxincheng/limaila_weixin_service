package com.limaila.limaila_weixin_service.base.message.request.message;

import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
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
public class BaseWxReqMessage extends BaseWxReq {

    //消息ID，64位整型
    private Long MsgId;
}
