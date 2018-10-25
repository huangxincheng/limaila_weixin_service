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
public class BaseReqMessage {

    //开发者微信号
    private String ToUserName;

    //发送方账号（一个OpenId）
    private String FromUserName;

    //消息创建时间（整型）
    private Long CreateTime;

    //消息类型
    private String MsgType;

    //消息ID，64位整型
    private Long MsgId;
}
