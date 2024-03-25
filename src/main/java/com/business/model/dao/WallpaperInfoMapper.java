package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.mobile.wallpaper.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.MyCollectRespDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.pojo.WallpaperInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WallpaperInfoMapper extends MPJBaseMapper<WallpaperInfo> {

    Page<WallpaperInfoVO> pageList(Page<WallpaperInfo> page, WallpaperInfoPageReqDTO reqDTO);

    Page<WallpaperPageVO> mobilePageList(Page<WallpaperInfo> page, WallpaperPageReqDTO reqDTO);

    WallpaperDetailsInfoVO getWallpaperDetailsInfo(@Param("id") Long id);

    Page<MyCollectRespDTO> getMyCollect(Page<WallpaperInfo> page, @Param("userId") Long userId);

}
