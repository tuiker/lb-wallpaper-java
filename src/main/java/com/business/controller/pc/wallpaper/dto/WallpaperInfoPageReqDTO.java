package com.business.controller.pc.wallpaper.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "壁纸信息分页列表查询请求 DTO")
@Data
public class WallpaperInfoPageReqDTO extends PageDaoEntity {

    @Schema(title = "排序方式", description = "排序方式，1：按创建时间倒序，2：按下载量倒序", type = "Integer")
    private Integer sortType;

    @Schema(title = "壁纸名称", description = "壁纸名称，模糊查询", type = "String")
    private String name;
}
