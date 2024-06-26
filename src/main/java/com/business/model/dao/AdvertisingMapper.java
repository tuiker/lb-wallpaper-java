package com.business.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.controller.pc.advertising.dto.AdvPageReqDTO;
import com.business.controller.pc.advertising.vo.AdvertisingVO;
import com.business.model.pojo.Advertising;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvertisingMapper extends BaseMapper<Advertising> {

    Page<AdvertisingVO> pageList(Page<Advertising> page, AdvPageReqDTO reqDTO);

    MobileAdvertisingVO getRandomAdv(@Param("contentsType") Integer contentsType);
}