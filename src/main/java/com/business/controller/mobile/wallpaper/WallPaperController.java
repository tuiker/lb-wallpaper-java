package com.business.controller.mobile.wallpaper;

import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mobile/wallpaper")
@Tag(name = "用户端 - 壁纸信息控制层")
public class WallPaperController {

    @Resource
    private IWallpaperInfoService wallpaperInfoService;

    @Operation(summary = "分页查询壁纸列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<WallpaperPageVO>> pageList(WallpaperPageReqDTO reqDTO){
        return ResultVO.success(wallpaperInfoService.pageList(reqDTO));
    }

    @Operation(summary = "根据ID获取壁纸详细信息")
    @GetMapping("/getWallpaperDetailsInfo")
    public ResultVO<WallpaperDetailsInfoVO> getWallpaperDetailsInfo(@RequestParam("id") Long id){
        return ResultVO.success(wallpaperInfoService.getWallpaperDetailsInfo(id));
    }

}
