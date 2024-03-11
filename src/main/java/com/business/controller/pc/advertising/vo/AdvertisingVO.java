package com.business.controller.pc.advertising.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(title = "广告信息", description = "广告")
public class AdvertisingVO {
    private Integer id;

    @Schema(title = "广告名", description = "广告图片", name = "advName")
    private String advName;

    @Schema(title = "广告内容类型", description = "1.图片；2.视频", name = "contentsType")
    private Integer contentsType;

    @Schema(title = "广告内容 图片或视频", description = "广告内容 图片或视频", name = "advContents")
    private String advContents;

    @Schema(title = "广告路径类型", description = "1.广告链接；", name = "urlType")
    private Integer urlType;

    @Schema(title = "广告路径", description = "广告路径", name = "advUrl")
    private String advUrl;

    @Schema(title = "广告描述", description = "广告描述", name = "advDesc")
    private String advDesc;

    @Schema(title = "创建时间", description = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //后端返回给前端的时间格式
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}