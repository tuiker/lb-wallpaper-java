package com.business.controller.pc.feedbackRecord.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "壁纸信息分页列表查询请求 DTO")
@Data
public class FeedbackRecordPageReqDTO extends PageDaoEntity {

    @Schema(title = "反馈类型", description = "1：问题，2：建议", type = "Integer")
    private Integer feedbackType;

}
