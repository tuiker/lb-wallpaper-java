package com.business.service.wallpaper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.pojo.WallpaperInfo;

/**
 * 壁纸信息 Service接口
 * @Author yxf
 **/
public interface IWallpaperInfoService extends IService<WallpaperInfo> {

    /**
     * 分页查询壁纸信息
     * @param reqDTO
     * @return
     */
    PageResult<WallpaperInfoVO> pageList(WallpaperInfoPageReqDTO reqDTO);

    /**
     * 新增壁纸信息
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addWallpaperInfo(WallpaperAddReqDTO reqDTO);

    /**
     * 修改壁纸信息
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateWallpaperInfo(WallpaperUpdateReqDTO reqDTO);

}
