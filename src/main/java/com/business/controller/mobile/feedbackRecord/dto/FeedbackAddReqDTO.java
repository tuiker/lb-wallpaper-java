package com.business.controller.mobile.feedbackRecord.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "用户反馈记录新增请求 DTO")
@Data
public class FeedbackAddReqDTO {

    @Schema(title = "反馈类型，1：问题，2：建议", description = "反馈类型，1：问题，2：建议", type = "Integer")
    private Integer feedbackType;

    @Schema(title = "反馈内容", description = "反馈内容", type = "String")
    private String feedbackContent;

    @Schema(title = "反馈的图片，数组格式字符串", description = "反馈的图片，数组格式字符串", type = "String")
    private String feedbackImgList;

}
