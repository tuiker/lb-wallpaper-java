package com.business.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.business.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("advertising")
@Schema(title = "广告信息实体类")
public class Advertising extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 广告名称 */
    private String advName;

    /** 广告内容类型 1.图片；2.视频 */
    private Integer contentsType;

    /** 广告内容 图片或视频 */
    private String advContents;

    /** 广告跳转路径类型 1.广告链接； */
    private Integer urlType;

    /** 广告跳转路径 */
    private String advUrl;

    /** 广告描述 */
    private String advDesc;
}