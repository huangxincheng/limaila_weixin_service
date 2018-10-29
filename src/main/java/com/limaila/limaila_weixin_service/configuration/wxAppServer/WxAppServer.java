package com.limaila.limaila_weixin_service.configuration.wxAppServer;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxAppServer {

    private String appId;

    private String appSecret;

    private String appToken;

}
