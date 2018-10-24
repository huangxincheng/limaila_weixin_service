package com.limaila.limaila_weixin_service.configuration.wxAppServer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("wx")
public class WxAppServerProperties {

    private Map<String, WxAppServer> appServers;

    public Map<String, WxAppServer> getAppServers() {
        return appServers;
    }

    public void setAppServers(Map<String, WxAppServer> appServers) {
        this.appServers = appServers;
    }

    public WxAppServer getWxAppServer(String key) {
        return this.appServers.get(key);
    }
}
