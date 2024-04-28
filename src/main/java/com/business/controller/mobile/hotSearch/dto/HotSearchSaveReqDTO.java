package com.business.controller.mobile.hotSearch.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "热搜保存请求 DTO")
@Data
public class HotSearchSaveReqDTO {

    @Schema(title = "搜索关键词", description = "搜索关键词", type = "String")
    private String keyword;

}
