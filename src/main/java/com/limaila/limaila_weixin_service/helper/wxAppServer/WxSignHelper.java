package com.limaila.limaila_weixin_service.helper.wxAppServer;


import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class WxSignHelper {

    private static final Logger logger = LoggerFactory.getLogger(WxSignHelper.class);
    /**
     * 开发者通过检验signature对请求进行校验
     * @param token token
     * @param signature signature
     * @param timestamp timestamp
     * @param nonce nonce
     * @return
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
//        1）将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
//        2）将三个参数字符串拼接成一个字符串进行sha1加密
        String tmpStr = DigestUtils.sha1Hex(arr[0] + arr[1] + arr[2]);
//        3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        boolean check = StringUtils.pathEquals(signature, tmpStr);
        logger.info("{} {} {}", WxSignHelper.class.getSimpleName(), "checkSignature", check);
        return check;
    }

}
