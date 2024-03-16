package com.business.controller.mobile.consumerUser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户登录请求 DTO")
public class LoginReqDTO {

    @Schema(title = "手机号", description = "手机号", type = "String")
    private String phone;

    @Schema(title = "验证码", description = "验证码", type = "String")
    private String verifyCode;

}
