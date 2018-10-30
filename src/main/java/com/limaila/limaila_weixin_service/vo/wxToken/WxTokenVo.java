package com.limaila.limaila_weixin_service.vo.wxToken;

import com.limaila.limaila_weixin_service.vo.wxBase.WxErrorVo;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxTokenVo extends WxErrorVo {

    private String access_token;

    private Integer expires_in;
}
