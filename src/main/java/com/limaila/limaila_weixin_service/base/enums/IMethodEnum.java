package com.limaila.limaila_weixin_service.base.enums;

public enum  IMethodEnum {

    GET("get"),

    POST("post"),
    ;

    private String name;

    IMethodEnum(String name) {
        this.name = name;
    }
}
