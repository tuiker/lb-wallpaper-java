package com.business.controller.mobile.favorites.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(title = "我的壁纸收藏响应 VO", description = "我的壁纸收藏响应 VO")
public class MyCollectRespVO {

    @Schema(title = "收藏夹ID", description = "收藏夹ID", name = "id")
    private Long id;

    @Schema(title = "收藏夹标题", description = "收藏夹标题", name = "title")
    private String title;

    @Schema(title = "收藏夹描述", description = "收藏夹描述", name = "describe")
    private String favoritesDesc;

    @Schema(title = "收藏夹创建时间", description = "收藏夹创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(title = "壁纸图片访问路径集合", description = "壁纸图片访问路径集合", name = "imgUrlList")
    private String imgUrlList;


}
