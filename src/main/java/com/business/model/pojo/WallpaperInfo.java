package com.business.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.business.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("wallpaper_info")
@Schema(title = "壁纸信息实体类")
public class WallpaperInfo extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 壁纸名称 */
    private String name;

    /** 壁纸图片访问路径集合 */
    private String imgUrlList;

    /** 是否为合集，0：否，1：是 */
    private Integer isCollection;

    /** 分类ID */
    private Long categoryId;

    /** 详细介绍 */
    private String details;

    /** 下载量 */
    private Integer downloadNum;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
