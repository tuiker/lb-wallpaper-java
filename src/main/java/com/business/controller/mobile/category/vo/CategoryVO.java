package com.business.controller.mobile.category.vo;

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

}
