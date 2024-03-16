package com.business.controller.mobile.consumerUser.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录结果响应 VO")
public class LoginResultVO {

    @Schema(title = "用户token")
    private String token;

    @Schema(title = "用户ID")
    private Long id;

    @Schema(title = "用户昵称")
    private String nickname;

    @Schema(title = "头像")
    private String headImg;

    @Schema(title = "手机号")
    private String phone;

}
