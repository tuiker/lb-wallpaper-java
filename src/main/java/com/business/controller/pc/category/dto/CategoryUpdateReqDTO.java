package com.business.controller.pc.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "壁纸分类修改请求 DTO", description = "壁纸分类修改请求 DTO")
public class CategoryUpdateReqDTO {

    @Schema(title = "分类ID", description = "分类ID", name = "id")
    private Long id;

    @Schema(title = "分类名称", description = "分类名称", name = "name")
    private String name;

    @Schema(title = "分类详细信息", description = "分类详细信息", name = "details")
    private String details;

}
