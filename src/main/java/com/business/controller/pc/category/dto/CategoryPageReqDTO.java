package com.business.controller.pc.category.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "壁纸分类分页列表查询请求 DTO")
@Data
public class CategoryPageReqDTO extends PageDaoEntity {

    @Schema(title = "创建时间-开始时间", description = "创建时间-开始时间", type = "String")
    private String startTime;

    @Schema(title = "创建时间-结束时间", description = "创建时间-结束时间", type = "String")
    private String endTime;

    @Schema(title = "分类名称", description = "分类名称，模糊查询", type = "String")
    private String name;

}
