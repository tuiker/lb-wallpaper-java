package com.business.service.wallpaper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.pojo.WallpaperInfo;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 用户端 - 分页查询壁纸信息
     * @param reqDTO
     * @return
     */
    PageResult<WallpaperPageVO> pageList(WallpaperPageReqDTO reqDTO);

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

    /**
     * 根据ID获取壁纸详细信息
     * @param id
     * @return
     */
    WallpaperDetailsInfoVO getWallpaperDetailsInfo(Long id);

}
