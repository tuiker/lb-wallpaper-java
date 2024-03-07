package com.business.model.dao.system;

import com.github.yulichang.base.MPJBaseMapper;
import com.business.model.pojo.system.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper extends MPJBaseMapper<SysRoleMenu> {

    List<Integer> getRoleMenuIds(Integer roleId);

}