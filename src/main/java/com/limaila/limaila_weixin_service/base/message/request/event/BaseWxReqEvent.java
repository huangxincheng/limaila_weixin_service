package com.limaila.limaila_weixin_service.base.message.request.event;

import com.limaila.limaila_weixin_service.base.message.request.BaseWxReq;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseWxReqEvent extends BaseWxReq {

    private String Event;
}
