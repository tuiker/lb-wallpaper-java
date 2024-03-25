package com.business.controller.mobile.wallpaper.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "我的壁纸收藏响应 VO", description = "我的壁纸收藏响应 VO")
public class MyCollectRespDTO {

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

}
