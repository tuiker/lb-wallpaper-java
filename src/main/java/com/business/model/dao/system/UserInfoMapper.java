package com.business.model.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.system.dto.UserPageReqDTO;
import com.business.controller.pc.system.vo.UserInfoVO;
import com.business.model.pojo.system.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<UserInfoVO> pageList(Page<UserInfo> page, @Param("reqDTO") UserPageReqDTO reqDTO);

}