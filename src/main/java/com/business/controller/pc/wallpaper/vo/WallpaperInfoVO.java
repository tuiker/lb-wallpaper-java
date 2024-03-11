package com.business.controller.pc.wallpaper.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Schema(title = "壁纸信息", description = "壁纸信息对象")
public class WallpaperInfoVO {

    @Schema(title = "ID", description = "ID", name = "id")
    private Long id;

    @Schema(title = "壁纸名称", description = "壁纸名称", name = "name")
    private String name;

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

    @Schema(title = "创建时间", description = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
