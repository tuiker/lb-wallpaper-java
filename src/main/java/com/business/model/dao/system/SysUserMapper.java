package com.business.model.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.system.dto.UserPageReqDTO;
import com.business.controller.pc.system.vo.UserInfoVO;
import com.business.model.pojo.system.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends BaseMapper<SysUser> {

    Page<UserInfoVO> pageList(Page<SysUser> page, @Param("reqDTO") UserPageReqDTO reqDTO);

}