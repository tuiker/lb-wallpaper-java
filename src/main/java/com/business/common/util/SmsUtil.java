package com.business.common.util;

import com.business.common.constant.SmsConstant;
import com.unimtx.Uni;
import com.unimtx.UniResponse;
import com.unimtx.model.UniOtp;
import org.springframework.stereotype.Component;

/**
 * @Author: GaoLu
 * @Date: 2023-10-26 13:09
 * @Description: 短讯服务工具
 */
public class SmsUtil {

    /**
     * @Description 手机发送验证码
     * @Author GaoLu
     * @Date 2023/10/30
     * @Return
     * @Param phone
     **/
    public static UniResponse sendVerificationCode(String phone) {
        Uni.init(SmsConstant.UNIMTX_ACCESS_KEY_ID, SmsConstant.UNIMTX_ACCESS_KEY_SECRET);
        return UniOtp.build().setTo(phone).setSignature(SmsConstant.SIGNATURE).send();
    }

    /**
     * @Description 手机验证码校验
     * @Author GaoLu
     * @Date 2023/10/26
     * @Return
     * @Param phone 手机号
     * @Param code 验证码
     **/
    public static boolean verifyCodePhone(String phone, String code) {
        Uni.init(SmsConstant.UNIMTX_ACCESS_KEY_ID, SmsConstant.UNIMTX_ACCESS_KEY_SECRET);
        UniResponse res = UniOtp.build()
                .setTo(phone)
                .setCode(code) // 用户提交的验证码
                .verify();
        return res.valid;
    }

}
