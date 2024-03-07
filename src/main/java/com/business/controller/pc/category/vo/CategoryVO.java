package com.business.controller.pc.category.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(title = "分类信息", description = "分类信息对象")
public class CategoryVO {

    @Schema(title = "分类id", description = "分类id", name = "id")
    private Long id;

    @Schema(title = "分类名称", description = "分类名称", name = "name")
    private String name;

    @Schema(title = "分类详细信息", description = "分类详细信息", name = "details")
    private String details;

    @Schema(title = "创建时间", description = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(title = "壁纸数", description = "壁纸数", name = "wallpaperNum")
    private Integer wallpaperNum;

    @Schema(title = "下载量", description = "下载量", name = "downloadNum")
    private Integer downloadNum;
}
