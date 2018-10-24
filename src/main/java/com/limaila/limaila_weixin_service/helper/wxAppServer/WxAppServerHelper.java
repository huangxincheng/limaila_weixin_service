package com.limaila.limaila_weixin_service.helper.wxAppServer;

import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServer;
import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WxAppServerHelper {

    @Autowired
    private WxAppServerProperties wxAppServerProperties;

    /**
     * 根据Key获取公众号配置信息
     * @param key key
     * @return 公众号信息
     */
    public WxAppServer getWxAppServer(String key) {
        return wxAppServerProperties.getWxAppServer(key);
    }
}
