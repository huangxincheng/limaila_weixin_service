package com.limaila.limaila_weixin_service.base.enums;

public enum WxEventEnum {

    /**
     * 订阅事件
     */
    subscribe,

    /**
     * 取消订阅事件
     */
    unsubscribe,

    /**
     * 扫描带参数二维码事件
     */
    SCAN,

    /**
     *  上报地理位置事件
     */
    LOCATION,

    /**
     *  自定义菜单事件
     */
    CLICK,

    /**
     * 模板消息任务确认事件
     */
    TEMPLATESENDJOBFINISH,



    ;
}
