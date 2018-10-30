package com.limaila.limaila_weixin_service;

import com.limaila.limaila_weixin_service.configuration.wxAppServer.WxAppServerKey;
import com.limaila.limaila_weixin_service.dao.WxUserMapper;
import com.limaila.limaila_weixin_service.entity.WxUser;
import com.limaila.limaila_weixin_service.helper.wxToken.WxTokenHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LimailaWeixinServiceApplicationTests {

    @Test
    public void contextLoads() {
//        ValueOperations<String, String> vo = redisTemplate.opsForValue();
//        vo.set("a1","a2");
//        String a1 = vo.get("a1");
//        System.out.println(a1);
//
//        HashMap map = new HashMap<>();
//        map.put("a6", "a8");
//        reidsCacheTemplate.opsForValue().set("bbq", map);
//
//        HashMap mp = (HashMap)reidsCacheTemplate.opsForValue().get("bbq");
//        System.out.println(mp);
//        String wxToken = wxTokenHelper.getWxToken(WxAppServerKey.LIMAILA);
//        System.out.println("wxToken = " + wxToken);

        WxUser wxUser = new WxUser();
        wxUser.setWxKey(WxAppServerKey.LIMAILA);
        wxUser.setWxNickname("黄信程");
        wxUserMapper.insertSelective(wxUser);
    }


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate<String, Serializable> reidsCacheTemplate;

    @Autowired
    private WxTokenHelper wxTokenHelper;

    @Autowired
    private WxUserMapper wxUserMapper;
}
