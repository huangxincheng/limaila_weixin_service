package com.limaila.limaila_weixin_service.service.impl;

import com.limaila.limaila_weixin_service.dao.WxUserMapper;
import com.limaila.limaila_weixin_service.entity.WxUser;
import com.limaila.limaila_weixin_service.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserMapper wxUserMapper;

    @Override
    public int add(WxUser wxUser) {
        return wxUserMapper.insertSelective(wxUser);
    }

    @Override
    public int update(WxUser wxUser) {
        return wxUserMapper.updateByPrimaryKeySelective(wxUser);
    }

    @Override
    public WxUser get(String wxOpenid, String wxKey) {
        return wxUserMapper.selectByWxOpenid(wxOpenid, wxKey);
    }

    @Override
    public int syncWxUser(WxUser wxUser) {
        WxUser wu = this.get(wxUser.getWxOpenid(), wxUser.getWxKey());
        if (wu == null) {
            return this.add(wxUser);
        } else {
            return this.update(wxUser);
        }
    }
}
