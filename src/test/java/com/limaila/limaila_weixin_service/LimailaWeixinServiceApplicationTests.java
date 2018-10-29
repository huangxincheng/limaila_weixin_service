package com.limaila.limaila_weixin_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LimailaWeixinServiceApplicationTests {

    @Test
    public void contextLoads() {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set("a1","a2");
        String a1 = vo.get("a1");
        System.out.println(a1);
    }


    @Autowired
    private StringRedisTemplate redisTemplate;


}
