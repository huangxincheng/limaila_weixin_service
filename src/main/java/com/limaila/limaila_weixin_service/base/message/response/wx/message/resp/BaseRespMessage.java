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
public class BaseRespMessage {

    //接收方帐号（收到的OpenID）
    private String ToUserName;

    //开发者微信号
    private String FromUserName;

    //消息创建时间（整型）
    private Long CreateTime;

    //消息类型
    private String MsgType;
}
