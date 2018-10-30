package com.limaila.limaila_weixin_service.dao;

import com.limaila.limaila_weixin_service.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxUserMapper {
    int deleteByPrimaryKey(@Param("id") Long id, @Param("wxKey") String wxKey);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(@Param("id") Long id, @Param("wxKey") String wxKey);

    int updateByPrimaryKeySelective(WxUser record);
}