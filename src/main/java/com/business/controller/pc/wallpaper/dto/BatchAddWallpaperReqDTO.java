package com.business.controller.pc.wallpaper.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "批量新增壁纸信息请求 DTO", description = "批量新增壁纸信息请求 DTO")
public class BatchAddWallpaperReqDTO {

    @Schema(title = "壁纸分类名称", description = "壁纸分类名称", name = "categoryName")
    private String categoryName;

    @Schema(title = "壁纸文件上级目录地址", description = "壁纸文件上级目录地址", name = "folderPath")
    private String folderPath;

}
