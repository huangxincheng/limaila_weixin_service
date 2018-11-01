package com.limaila.limaila_weixin_service.helper.user;

import com.alibaba.fastjson.JSON;
import com.limaila.limaila_weixin_service.api.wxApi.WxApi;
import com.limaila.limaila_weixin_service.helper.wxToken.WxTokenHelper;
import com.limaila.limaila_weixin_service.vo.wxUser.WxUserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WxUserHelper {

    @Autowired
    private WxTokenHelper wxTokenHelper;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(WxUserHelper.class);

    public WxUserInfoVo getWxUserInfo(String key, String openid) {
        String wxToken = wxTokenHelper.getWxToken(key);
        String api = String.format(WxApi.WX_USER_INFO_GET, wxToken, openid);
        WxUserInfoVo wxUserInfoVo = restTemplate.getForObject(api, WxUserInfoVo.class);
        logger.info("[WX] [USER_INFO] wxUserInfoVo = " + JSON.toJSONString(wxUserInfoVo));
        return  wxUserInfoVo;
    }
}
