package com.business.controller.mobile.wallpaper.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "壁纸详细信息", description = "壁纸详细信息对象")
public class WallpaperDetailsInfoVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "壁纸名称", description = "壁纸名称", name = "name")
    private String name;

    @Schema(title = "封面壁纸图片", description = "封面壁纸图片", name = "coverImage")
    private String coverImage;

    @Schema(title = "壁纸图片访问路径集合", description = "壁纸图片访问路径集合", name = "imgUrlList")
    private String imgUrlList;

    @Schema(title = "是否为合集，0：否，1：是", description = "是否为合集，0：否，1：是", name = "isCollection")
    private Integer isCollection;

    @Schema(title = "分类id", description = "分类id", name = "categoryId")
    private Long categoryId;

    @Schema(title = "分类名称", description = "分类名称", name = "categoryName")
    private String categoryName;

    @Schema(title = "详细介绍", description = "详细介绍", name = "details")
    private String details;

    @Schema(title = "下载量", description = "下载量", name = "downloadNum")
    private Integer downloadNum;

    @Schema(title = "收藏量", description = "收藏量", name = "collectNum")
    private Integer collectNum;

    @Schema(title = "用户ID", description = "用户ID", name = "userId")
    private Long userId;

    @Schema(title = "作者昵称", description = "作者昵称", name = "nickname")
    private String nickname;

    @Schema(title = "作者头像", description = "作者头像", name = "headImg")
    private String headImg;

    @Schema(title = "是否已收藏", description = "是否已收藏，true：是，false：否", name = "isCollect")
    private Boolean isCollect = false;

    @Schema(title = "收藏夹ID", description = "收藏夹ID", name = "favoritesId")
    private Long favoritesId;

}
