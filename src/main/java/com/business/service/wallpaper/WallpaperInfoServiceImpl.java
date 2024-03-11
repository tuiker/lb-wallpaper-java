package com.business.service.wallpaper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.dao.CategoryMapper;
import com.business.model.dao.WallpaperInfoMapper;
import com.business.model.pojo.Category;
import com.business.model.pojo.WallpaperInfo;
import com.business.service.category.ICategoryService;
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
        //设置是否为合集，0：否，1：是
        wallpaperInfo.setIsCollection(imgUrlList.size() > 1 ? 1 : 0);

        this.updateById(wallpaperInfo);

        return ResultVO.success(true);
    }
}
