package com.business.service.favorites;

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
import com.business.model.dao.WallpaperCollectRecordMapper;
import com.business.model.pojo.Favorites;
import com.business.model.pojo.WallpaperCollectRecord;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户收藏夹 Service接口实现类
 * @Author yxf
 **/
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements IFavoritesService {

    @Resource
    private WallpaperCollectRecordMapper wallpaperCollectRecordMapper;

    /**
     * 收藏壁纸
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addCollect(AddCollectReqDTO reqDTO) {
        //用户未收藏该壁纸，才去新增收藏记录
        if(!this.checkIsCollect(reqDTO.getWallpaperId())){
            WallpaperCollectRecord record = new WallpaperCollectRecord();
            record.setFavoritesId(reqDTO.getFavoritesId());
            record.setWallpaperId(reqDTO.getWallpaperId());
            record.setUserId(SecurityUtils.getLoginUserId());
            record.setCreateTime(LocalDateTime.now());
            wallpaperCollectRecordMapper.insert(record);
        }
        return ResultVO.success(true);
    }

    /**
     * 取消收藏壁纸
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> cancelCollect(AddCollectReqDTO reqDTO) {
        wallpaperCollectRecordMapper.delete(
                new LambdaUpdateWrapper<WallpaperCollectRecord>()
                        .eq(WallpaperCollectRecord::getUserId, SecurityUtils.getLoginUserId())
                        .eq(WallpaperCollectRecord::getWallpaperId, reqDTO.getWallpaperId())
        );
        return ResultVO.success(true);
    }

    /**
     * 根据壁纸ID校验用户是否已收藏该壁纸
     * @param wallpaperId 壁纸ID
     * @return
     */
    @Override
    public Boolean checkIsCollect(Long wallpaperId) {
        //查询当前用户是否已收藏该壁纸
        Long count = wallpaperCollectRecordMapper.selectCount(
                new LambdaUpdateWrapper<WallpaperCollectRecord>()
                        .eq(WallpaperCollectRecord::getUserId, SecurityUtils.getLoginUserId())
                        .eq(WallpaperCollectRecord::getWallpaperId, wallpaperId)
        );
        return count > 0;
    }

    /**
     * 分页查询我的收藏壁纸列表
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<MyCollectRespVO> getMyCollect(MyCollectPageReqDTO reqDTO) {
        Page<MyCollectRespVO> page = baseMapper.getMyCollect(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()),
                SecurityUtils.getLoginUserId());
        return new PageResult<>(page.getRecords(), page.getTotal());
    }
}
