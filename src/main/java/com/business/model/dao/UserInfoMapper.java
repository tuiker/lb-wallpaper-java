package com.business.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.dto.UserPageReqDTO;
import com.business.controller.pc.vo.UserInfoVO;
import com.business.model.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<UserInfoVO> pageList(Page<UserInfo> page, @Param("reqDTO") UserPageReqDTO reqDTO);

}