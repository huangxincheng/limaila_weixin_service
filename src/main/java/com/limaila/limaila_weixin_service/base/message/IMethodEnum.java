package com.limaila.limaila_weixin_service.base.message;

public enum  IMethodEnum {

    GET("get"),

    POST("post"),
    ;

    private String name;

    IMethodEnum(String name) {
        this.name = name;
    }
}
