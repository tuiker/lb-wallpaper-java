package com.business.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("wallpaper_collect_record")
@Schema(title = "壁纸收藏记录实体类")
public class WallpaperCollectRecord {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 壁纸ID */
    private Long wallpaperId;

    /** 用户ID */
    private Long userId;

    /** 收藏夹ID */
    private Long favoritesId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
