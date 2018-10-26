package com.limaila.limaila_weixin_service.base.enums;

public enum WxReqMsgEnum {

    /**
     * 文本消息
     */
    TEXT("text"),

    /**
     * 图片消息
     */
    IMAGE("image"),

    /**
     * 语音消息
     */
    VOICE("voice"),

    /**
     * 视频消息
     */
    VIDEO("video"),

    /**
     * 小视频消息
     */
    SHORTVIDEO("shortvideo"),

    /**
     * 地理位置消息
     */
    LOCATION("location"),

    /**
     * 链接消息
     */
    LINK("link"),
    ;

    private String value;

    WxReqMsgEnum(String value) {
        this.value = value;
    }

    public String val() {
        return value;
    }
}
