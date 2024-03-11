package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.pojo.WallpaperInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WallpaperInfoMapper extends MPJBaseMapper<WallpaperInfo> {

    Page<WallpaperInfoVO> pageList(Page<WallpaperInfo> page, WallpaperInfoPageReqDTO reqDTO);

}
