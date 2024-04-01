package com.business.controller.mobile.consumerUser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户使用密码登录请求 DTO")
public class LoginByPasswordReqDTO {

    @Schema(title = "手机号", description = "手机号", type = "String")
    private String phone;

    @Schema(title = "密码", description = "密码", type = "String")
    private String password;

}
