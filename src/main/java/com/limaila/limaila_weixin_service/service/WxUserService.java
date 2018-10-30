package com.limaila.limaila_weixin_service.service;

import com.limaila.limaila_weixin_service.entity.WxUser;

public interface WxUserService {

    int syncWxUser(WxUser wxUser);

    WxUser get(String wxOpenid, String wxKey);

}
