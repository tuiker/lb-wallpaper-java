package com.business.controller.mobile.consumerUser.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "用户信息修改请求 DTO")
public class ConsumerUserUpdateReqDTO {

    @Schema(title = "ID", description = "ID", type = "Long")
    private Long id;

    @Schema(title = "用户昵称", description = "用户昵称", type = "String")
    private String nickname;

    @Schema(title = "头像", description = "头像", type = "String")
    private String headImg;

    @Schema(title = "性别", description = "1：男，2：女", type = "Integer")
    private Integer gender;

    @Schema(title = "生日", description = "生日", type = "String，日期格式字符串")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate birthday;

    @Schema(title = "签名", description = "签名", type = "String")
    private String signature;

}
