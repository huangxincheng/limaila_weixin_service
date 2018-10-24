package com.limaila.limaila_weixin_service.configuration.wxAppServer;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WxAppServer {

    private String appId;

    private String appSecret;

    private String appToken;

}
