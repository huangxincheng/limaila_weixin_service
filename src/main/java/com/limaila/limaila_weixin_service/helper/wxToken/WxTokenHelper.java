package com.limaila.limaila_weixin_service.helper.wxToken;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.limaila.limaila_weixin_service.api.wxApi.WxApi;
import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServer;
import com.limaila.limaila_weixin_service.constant.WxRedisKeyConstant;
import com.limaila.limaila_weixin_service.exception.WxException;
import com.limaila.limaila_weixin_service.helper.wxAppServer.WxAppServerHelper;
import com.limaila.limaila_weixin_service.vo.wxToken.WxTokenVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class WxTokenHelper {


    @Autowired
    private WxAppServerHelper wxAppServerHelper;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(WxTokenHelper.class);



    /**
     * 获取微信token
     * @return
     */
    public String getWxToken(String key) {
        WxAppServer wxAppServer = wxAppServerHelper.getWxAppServer(key);
        Assert.notNull(wxAppServer, "wxAppServer is not null");
        String value = stringRedisTemplate.opsForValue().get(String.format(WxRedisKeyConstant.WX_ACCESSTOKEN_KEY, key));
        if (value == null) {
            String api = String.format(WxApi.WX_TOKEN_GET, wxAppServer.getAppId(), wxAppServer.getAppSecret());
            WxTokenVo wxTokenVo = restTemplate.getForObject(api, WxTokenVo.class);
            if (wxTokenVo == null) {
                logger.error("[WX]获取微信token失败,微信返回:空");
                throw new WxException("[WX]获取微信token失败,微信返回:空");
            }
            if (StringUtils.isEmpty(wxTokenVo.getAccess_token())) {
                logger.error("[WX]获取微信token失败,微信返回:\n{}", wxTokenVo.toString());
                throw new WxException("[WX]获取微信token失败,微信返回:\n" + wxTokenVo.toString());
            }
            value = wxTokenVo.getAccess_token();
            stringRedisTemplate.opsForValue().set(String.format(WxRedisKeyConstant.WX_ACCESSTOKEN_KEY, key), value, wxTokenVo.getExpires_in() - 1000, TimeUnit.SECONDS);
        }
        return  value;
    }
}
