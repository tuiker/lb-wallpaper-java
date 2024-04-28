package com.business.service.wallpaper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageInFavoritesReqDTO;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.dao.WallpaperCollectRecordMapper;
import com.business.model.dao.WallpaperInfoMapper;
import com.business.model.pojo.WallpaperCollectRecord;
import com.business.model.pojo.WallpaperInfo;
import com.business.service.favorites.IFavoritesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 壁纸信息 Service接口实现
 * @Author yxf
 **/
@Service
public class WallpaperInfoServiceImpl extends ServiceImpl<WallpaperInfoMapper, WallpaperInfo> implements IWallpaperInfoService {

    @Resource
    private WallpaperInfoMapper wallpaperInfoMapper;

    @Resource
    private IFavoritesService favoritesService;

    @Resource
    private WallpaperCollectRecordMapper wallpaperCollectRecordMapper;

    /**
     * 分页查询壁纸信息
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<WallpaperInfoVO> pageList(WallpaperInfoPageReqDTO reqDTO) {
        if(StrUtil.isNotBlank(reqDTO.getName())){//模糊查询壁纸信息名称
            reqDTO.setName("%" + reqDTO.getName() + "%");
        }
        Page<WallpaperInfoVO> page = wallpaperInfoMapper.pageList(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    /**
     * 用户端 - 分页查询壁纸信息
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<WallpaperPageVO> pageList(WallpaperPageReqDTO reqDTO) {
        if(StrUtil.isNotBlank(reqDTO.getName())){//模糊查询壁纸信息名称
            reqDTO.setName("%" + reqDTO.getName() + "%");
        }
        Page<WallpaperPageVO> page = wallpaperInfoMapper.mobilePageList(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    /**
     * 新增壁纸信息
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addWallpaperInfo(WallpaperAddReqDTO reqDTO) {

        WallpaperInfo wallpaperInfo = BeanUtil.copyProperties(reqDTO, WallpaperInfo.class);
        wallpaperInfo.setCreateId(SecurityUtils.getLoginUserId());
        wallpaperInfo.setCreateTime(LocalDateTime.now());

        JSONArray imgUrlList = JSON.parseArray(wallpaperInfo.getImgUrlList());
        wallpaperInfo.setCoverImage(imgUrlList.get(0).toString());
        //设置是否为合集，0：否，1：是
        wallpaperInfo.setIsCollection(imgUrlList.size() > 1 ? 1 : 0);

        this.save(wallpaperInfo);
        return ResultVO.success(true);
    }

    /**
     * 修改壁纸信息
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> updateWallpaperInfo(WallpaperUpdateReqDTO reqDTO) {
        WallpaperInfo wallpaperInfo = BeanUtil.copyProperties(reqDTO, WallpaperInfo.class);
        wallpaperInfo.setUpdateId(SecurityUtils.getLoginUserId());
        wallpaperInfo.setUpdateTime(LocalDateTime.now());

        JSONArray imgUrlList = JSON.parseArray(wallpaperInfo.getImgUrlList());
        wallpaperInfo.setCoverImage(imgUrlList.get(0).toString());
        //设置是否为合集，0：否，1：是
        wallpaperInfo.setIsCollection(imgUrlList.size() > 1 ? 1 : 0);

        this.updateById(wallpaperInfo);

        return ResultVO.success(true);
    }

    /**
     * 根据ID获取壁纸详细信息
     * @param id
     * @return
     */
    @Override
    public WallpaperDetailsInfoVO getWallpaperDetailsInfo(Long id) {
        WallpaperDetailsInfoVO detailsInfo = wallpaperInfoMapper.getWallpaperDetailsInfo(id);

        WallpaperCollectRecord record = wallpaperCollectRecordMapper.selectOne(
                new LambdaUpdateWrapper<WallpaperCollectRecord>()
                        .eq(WallpaperCollectRecord::getUserId, SecurityUtils.getLoginUserId())
                        .eq(WallpaperCollectRecord::getWallpaperId, id)
        );
        if(null != record){
            detailsInfo.setIsCollect(true);
            detailsInfo.setFavoritesId(record.getFavoritesId());
        }
        return detailsInfo;
    }


    /**
     * 根据收藏夹ID分页查询该收藏夹中的壁纸
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<WallpaperPageVO> pageWallpaperInFavorites(WallpaperPageInFavoritesReqDTO reqDTO) {
        Page<WallpaperPageVO> page = baseMapper.pageWallpaperInFavorites(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

}
