package com.business.controller.pc.wallpaper.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "壁纸信息修改请求 DTO", description = "壁纸信息修改请求 DTO")
public class WallpaperUpdateReqDTO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "壁纸名称", description = "壁纸名称", name = "name")
    private String name;

    @Schema(title = "壁纸图片访问路径集合", description = "壁纸图片访问路径集合", name = "imgUrlList")
    private String imgUrlList;

    @Schema(title = "分类id", description = "分类id", name = "categoryId")
    private Long categoryId;

    @Schema(title = "详细介绍", description = "详细介绍", name = "details")
    private String details;

}
