package com.limaila.limaila_weixin_service.base.message.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseReqEvent extends BaseReq{

    private String Event;
}
