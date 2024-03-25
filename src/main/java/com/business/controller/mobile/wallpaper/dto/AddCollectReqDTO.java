package com.business.controller.mobile.wallpaper.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "壁纸收藏请求 DTO")
@Data
public class AddCollectReqDTO {

    @Schema(title = "壁纸ID", description = "壁纸ID", type = "Integer")
    private Long wallpaperId;

}
