package com.business.controller.mobile.wallpaper.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "我的收藏列表查询请求 DTO")
@Data
public class MyCollectPageReqDTO extends PageDaoEntity {


}
