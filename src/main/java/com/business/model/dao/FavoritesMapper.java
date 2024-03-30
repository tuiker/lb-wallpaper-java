package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.mobile.favorites.vo.MyCollectRespVO;
import com.business.model.pojo.Favorites;
import com.business.model.pojo.WallpaperInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoritesMapper extends MPJBaseMapper<Favorites> {

    Page<MyCollectRespVO> getMyCollect(Page<WallpaperInfo> page, @Param("userId") Long userId);
}
