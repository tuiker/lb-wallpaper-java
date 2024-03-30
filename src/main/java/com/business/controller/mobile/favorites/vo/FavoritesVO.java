package com.business.controller.mobile.favorites.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(title = "我的收藏夹信息对象VO", description = "我的收藏夹信息对象VO")
public class FavoritesVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    /** 用户ID */
    @Schema(title = "用户ID", description = "用户ID", name = "userId")
    private Long userId;

    @Schema(title = "标题", description = "标题", name = "title")
    private String title;

    @Schema(title = "描述", description = "描述", name = "describe")
    private String describe;

    @Schema(title = "创建时间", description = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
