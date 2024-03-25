package com.business.controller.mobile.consumerUser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户重设密码请求 DTO")
public class ResetPasswordReqDTO {

    @Schema(title = "验证码", description = "验证码", type = "String")
    private String verifyCode;

    @Schema(title = "第一次输入的密码", description = "第一次输入的密码", type = "String")
    private String password;

    @Schema(title = "第二次输入的密码", description = "第二次输入的密码", type = "String")
    private String againPassword;

}
