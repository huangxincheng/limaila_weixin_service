package com.limaila.limaila_weixin_service.base.message;

import com.limaila.limaila_weixin_service.base.enums.WxReqMsgEnum;
import com.limaila.limaila_weixin_service.base.message.request.BaseReqMessage;
import org.springframework.util.StringUtils;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
public class MessageChaining {

    private BaseReqMessage baseReqMessage;

    MessageChaining(BaseReqMessage baseReqMessage) {
        this.baseReqMessage = baseReqMessage;
    }

    private void handler() {
        if (StringUtils.pathEquals(WxReqMsgEnum.TEXT.val(), baseReqMessage.getMsgType())) {

        }
    }


}
