package com.limaila.limaila_weixin_service.base.message.request.event;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TemplatesendJobFinishEvent extends BaseWxReqEvent {

    private Integer MsgID;

    private String Status;
}
