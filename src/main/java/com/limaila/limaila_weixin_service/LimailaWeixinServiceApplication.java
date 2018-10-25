package com.limaila.limaila_weixin_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LimailaWeixinServiceApplication {

    /**
     * 配置RestTemplate
     * @param factory
     * @return
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        RestTemplate restTemplate = new RestTemplate(factory);
//        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    /**
     * 配置ClientHttpRequestFactory
     * @return
     */
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);//单位为ms
        factory.setConnectTimeout(10000);//单位为ms
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(LimailaWeixinServiceApplication.class, args);
    }
}
