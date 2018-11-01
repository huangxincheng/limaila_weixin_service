package com.limaila.limaila_weixin_service.api.wxApi;

public interface WxApi {


    /**
     * 1、建议公众号开发者使用中控服务器统一获取和刷新Access_token，其他业务逻辑服务器所使用的access_token均来自于该中控服务器，不应该各自去刷新，否则容易造成冲突，导致access_token覆盖而影响业务；
     * 2、目前Access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，新老access_token都可用，这保证了第三方业务的平滑过渡；
     * 3、Access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，可以触发access_token的刷新流程。
     * 公众号和小程序均可以使用AppID和AppSecret调用本接口来获取access_token。AppID和AppSecret可在“微信公众平台-开发-基本配置”页中获得（需要已经成为开发者，且帐号没有异常状态）。调用接口时，请登录“微信公众平台-开发-基本配置”提前将服务器IP地址添加到IP白名单中，点击查看设置方法，否则将无法调用成功。小程序无需配置IP白名单。
     * 接口调用请求说明
     * https请求方式: GET
     * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     */
    String WX_TOKEN_GET = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";


    /**
     * 获取用户基本信息(UnionID机制)
     * 在关注者与公众号产生消息交互后，公众号可获得关注者的OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的。对于不同公众号，同一用户的openid不同）。公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
     * 请注意，如果开发者有在多个公众号，或在公众号、移动应用之间统一用户帐号的需求，需要前往微信开放平台（open.weixin.qq.com）绑定公众号后，才可利用UnionID机制来满足上述需求。
     * UnionID机制说明：
     * 开发者可通过OpenID来获取用户基本信息。特别需要注意的是，如果开发者拥有多个移动应用、网站应用和公众帐号，可通过获取用户基本信息中的unionid来区分用户的唯一性，因为只要是同一个微信开放平台帐号下的移动应用、网站应用和公众帐号，用户的unionid是唯一的。换句话说，同一用户，对同一个微信开放平台下的不同应用，unionid是相同的。
     * 获取用户基本信息（包括UnionID机制）
     * 开发者可通过OpenID来获取用户基本信息。请使用https协议。
     * 接口调用请求说明
     * http请求方式: GET
     * https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
     */
    String WX_USER_INFO_GET = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s";


    /**
     * 临时二维码请求说明
     * http请求方式: POST
     * URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
     * POST数据格式：json
     * POST数据例子：{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
     * 或者也可以使用以下POST数据创建字符串形式的二维码参数：
     * {"expire_seconds": 604800, "action_name": "QR_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}
     *
     *
     *
     * 永久二维码请求说明
     * http请求方式: POST
     * URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
     * POST数据格式：json
     * POST数据例子：{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}
     *
     * 或者也可以使用以下POST数据创建字符串形式的二维码参数：
     * {"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "test"}}}
     */
    String WX_CODE_CREATE_TICKET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=${TOKEN}";


}
