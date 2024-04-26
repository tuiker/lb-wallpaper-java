package com.business.service.hotSearch;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.favorites.dto.AddCollectReqDTO;
import com.business.controller.mobile.favorites.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.favorites.vo.MyCollectRespVO;
import com.business.model.dao.FavoritesMapper;
import com.business.model.dao.HotSearchMapper;
import com.business.model.dao.WallpaperCollectRecordMapper;
import com.business.model.pojo.Favorites;
import com.business.model.pojo.HotSearch;
import com.business.model.pojo.WallpaperCollectRecord;
import com.business.service.favorites.IFavoritesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 热搜关键词信息 Service接口实现类
 * @Author yxf
 **/
@Service
public class HotSearchServiceImpl extends ServiceImpl<HotSearchMapper, HotSearch> implements IHotSearchService {

}
