package com.business.controller.pc.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * 菜单或按钮 响应 VO
 * @Author yxf
 */
@Data
@Schema(description ="菜单或按钮 响应 VO")
public class SysMenuRespVO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "菜单或按钮名称")
    private String name;

    @Schema(description = "权限类型：1:目录，2：菜单，3：按钮")
    private Integer type;

    @Schema(description = "父级权限ID")
    private Integer parentId;

    @Schema(description = "菜单路由地址")
    private String path;

    @Schema(description = "组件路径")
    private String component;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "是否隐藏：0：否，1：是")
    private Integer hidden;

    @Schema(description = "子（菜单或按钮）权限")
    private List<SysMenuRespVO> childrenList = new ArrayList<>();
}
