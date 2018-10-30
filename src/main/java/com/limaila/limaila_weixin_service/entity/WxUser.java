package com.limaila.limaila_weixin_service.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxUser implements Serializable {
    private Long id;

    private String wxOpenid;

    private String wxNickname;

    private String wxUnionid;

    private String wxHeadimgurl;

    private Integer wxSex;

    private String wxCity;

    private String wxCountry;

    private String wxProvince;

    private String wxLanguage;

    private Date wxSubscribeTime;

    private String wxSubscribeScene;

    private String wxQrScene;

    private String wxQrSceneStr;

    private String wxKey;

    private Integer wxSubscribe;
}