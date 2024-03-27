package com.business.controller.pc.feedbackRecord.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(title = "用户反馈记录", description = "用户反馈记录")
public class FeedbackRecordVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "反馈类型，1：问题，2：建议", description = "反馈类型，1：问题，2：建议", name = "feedbackType")
    private Integer feedbackType;

    @Schema(title = "反馈内容", description = "反馈内容", name = "feedbackContent")
    private String feedbackContent;

    @Schema(title = "反馈的图片，数组格式字符串", description = "反馈的图片，数组格式字符串", name = "feedbackImgList")
    private String feedbackImgList;

    @Schema(title = "用户ID", description = "用户ID", name = "userId")
    private Long userId;

    @Schema(title = "创建时间", description = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(title = "用户昵称", description = "用户昵称", name = "nickname")
    private String nickname;

    @Schema(title = "用户手机号", description = "用户手机号", name = "phone")
    private String phone;
}
