package com.business.controller.pc.advertising.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "广告新增请求 DTO")
public class AdvAddReqDTO {

    @Schema(title = "名称", description = "广告名称", name = "advName")
    private String advName;

    @Schema(title = "广告内容类型", description = "1.图片；2.视频", name = "contentsType")
    private Integer contentsType;

    @Schema(title = "广告内容 图片或视频", description = "广告内容 图片或视频", name = "advContents")
    private String advContents;

    @Schema(title = "广告路径类型", description = "广告链接类型：1.链接；", name = "advTypeId")
    private int urlType;

    @Schema(title = "广告路径", description = "广告路径", name = "advUrl")
    private String advUrl;

    @Schema(title = "广告描述", description = "广告描述", name = "advDesc")
    private String advDesc;

}