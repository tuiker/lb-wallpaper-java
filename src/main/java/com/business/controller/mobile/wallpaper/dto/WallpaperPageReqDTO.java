package com.business.controller.mobile.wallpaper.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "壁纸信息分页列表查询请求 DTO")
@Data
public class WallpaperPageReqDTO extends PageDaoEntity {

    @Schema(title = "壁纸分类ID", description = "壁纸分类ID", type = "Integer")
    private Long categoryId;

    @Schema(title = "壁纸名称", description = "壁纸名称，模糊查询", type = "String")
    private String name;
}
