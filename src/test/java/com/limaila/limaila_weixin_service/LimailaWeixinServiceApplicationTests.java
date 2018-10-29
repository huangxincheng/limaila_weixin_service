package com.limaila.limaila_weixin_service;

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
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set("a1","a2");
        String a1 = vo.get("a1");
        System.out.println(a1);

        HashMap map = new HashMap<>();
        map.put("a6", "a8");
        reidsCacheTemplate.opsForValue().set("bbq", map);

        HashMap mp = (HashMap)reidsCacheTemplate.opsForValue().get("bbq");
        System.out.println(mp);
    }


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private RedisTemplate<String, Serializable> reidsCacheTemplate;


}
