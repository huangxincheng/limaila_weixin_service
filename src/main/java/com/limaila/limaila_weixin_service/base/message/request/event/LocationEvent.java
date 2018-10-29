package com.limaila.limaila_weixin_service.base.message.request.event;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationEvent extends BaseWxReqEvent {

    private Double Latitude;

    private Double Longitude;

    private Double Precision;

}
