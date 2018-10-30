package com.limaila.limaila_weixin_service.dao;

import com.limaila.limaila_weixin_service.entity.WxUser;

public interface WxUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}