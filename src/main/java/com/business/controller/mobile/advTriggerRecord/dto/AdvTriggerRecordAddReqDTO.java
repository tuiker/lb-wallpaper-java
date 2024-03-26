package com.business.controller.mobile.advTriggerRecord.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "广告触发记录新增请求 DTO")
@Data
@AllArgsConstructor
public class AdvTriggerRecordAddReqDTO {

    @Schema(title = "广告ID", description = "广告ID", type = "Integer")
    private Long advId;

    @Schema(title = "触发类型", description = "触发类型，1：广告展示，2：广告播放，3：广告点击", type = "Integer")
    private Integer triggerType;

}
