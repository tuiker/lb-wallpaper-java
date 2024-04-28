package com.business.controller.mobile.downloadRecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "分页列表-壁纸下载记录", description = "分页列表-壁纸下载记录")
public class DownloadRecordPageVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "壁纸名称", description = "壁纸名称", name = "name")
    private String name;

    @Schema(title = "壁纸的下载路径", description = "壁纸的下载路径", type = "wallpaperDownloadUrl")
    private String wallpaperDownloadUrl;

    @Schema(title = "是否为合集，0：否，1：是", description = "是否为合集，0：否，1：是", name = "isCollection")
    private Integer isCollection;

    @Schema(title = "详细介绍", description = "详细介绍", name = "details")
    private String details;
}
