package com.business.model.dao.system;

import com.github.yulichang.base.MPJBaseMapper;
import com.business.model.pojo.system.SysMenu;
import com.business.controller.pc.system.vo.SysMenuRespVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends MPJBaseMapper<SysMenu> {

    List<SysMenuRespVO> getSysMenuListByUserId(@Param("userId") Long userId);

}