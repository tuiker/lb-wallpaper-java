package com.business.controller.mobile.consumerUser.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "用户信息 VO")
public class ConsumerUserVO {

    @Schema(title = "ID")
    private Long id;

    @Schema(title = "用户昵称")
    private String nickname;

    @Schema(title = "头像")
    private String headImg;

    @Schema(title = "手机号")
    private String phone;

    @Schema(title = "性别，1：男，2：女")
    private Integer gender;

    @Schema(title = "生日")
    private LocalDate birthday;

    @Schema(title = "签名")
    private String signature;

}
