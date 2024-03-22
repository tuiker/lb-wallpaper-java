package com.business.controller.mobile.wallpaper.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "分页列表-壁纸信息", description = "分页列表-壁纸信息对象")
public class WallpaperPageVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "壁纸名称", description = "壁纸名称", name = "name")
    private String name;

    @Schema(title = "壁纸图片访问路径集合", description = "壁纸图片访问路径集合", name = "imgUrlList")
    private String imgUrlList;

    @Schema(title = "是否为合集，0：否，1：是", description = "是否为合集，0：否，1：是", name = "isCollection")
    private Integer isCollection;

    @Schema(title = "详细介绍", description = "详细介绍", name = "details")
    private String details;

    @Schema(title = "下载量", description = "下载量", name = "downloadNum")
    private Integer downloadNum;

    @Schema(title = "是否为广告", description = "是否为广告，false：否，true：是", name = "isAdv")
    private Boolean isAdv;

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

}
