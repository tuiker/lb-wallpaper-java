package com.business.controller.mobile.hotSearch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(title = "热搜关键词信息对象VO", description = "热搜关键词信息对象VO")
public class HotSearchVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "关键词", description = "关键词", name = "keyword")
    private String keyword;

    @Schema(title = "搜索次数", description = "搜索次数", name = "searchNum")
    private Integer searchNum;
}
