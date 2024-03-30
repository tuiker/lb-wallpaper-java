package com.business.controller.mobile.wallpaper.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "根据收藏夹ID分页查询该收藏夹中的壁纸 查询请求 DTO")
@Data
public class WallpaperPageInFavoritesReqDTO extends PageDaoEntity {

    @Schema(title = "收藏夹ID", description = "收藏夹ID", type = "Integer")
    private Long favoritesId;

}
