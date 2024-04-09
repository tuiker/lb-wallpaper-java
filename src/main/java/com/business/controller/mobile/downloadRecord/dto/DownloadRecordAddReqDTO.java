package com.business.controller.mobile.downloadRecord.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "下载记录新增请求 DTO")
@Data
public class DownloadRecordAddReqDTO {

    @Schema(title = "壁纸ID", description = "壁纸ID", type = "Integer")
    private Long wallpaperId;

    @Schema(title = "壁纸的下载路径", description = "壁纸的下载路径", type = "String")
    private String wallpaperDownloadUrl;

}
