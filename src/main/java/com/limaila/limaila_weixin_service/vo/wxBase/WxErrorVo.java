package com.limaila.limaila_weixin_service.vo.wxBase;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WxErrorVo implements Serializable {

    private Integer errcode;

    private String errmsg;
}
