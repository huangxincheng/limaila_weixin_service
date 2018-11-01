package com.limaila.limaila_weixin_service.vo.wxUser;


import com.limaila.limaila_weixin_service.vo.wxBase.WxErrorVo;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxUserInfoVo extends WxErrorVo {

    private Integer subscribe;

    private String openid;

    private String nickname;

    private Integer sex;

    private String city;

    private String country;

    private String province;

    private String language;

    private String headimgurl;

    private Long subscribe_time;

    private String unionid;

    private String remark;

    private String groupid;

    private String subscribe_scene;

    private String qr_scene;

    private String qr_scene_str;

}
