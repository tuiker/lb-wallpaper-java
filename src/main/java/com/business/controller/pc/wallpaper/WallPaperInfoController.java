package com.business.controller.pc.wallpaper;

import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.service.category.ICategoryService;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pc/wallpaper")
@Tag(name = "admin端 - 壁纸信息控制层")
public class WallPaperInfoController {

    @Resource
    private IWallpaperInfoService wallpaperInfoService;

    @Operation(summary = "分页查询壁纸信息列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<WallpaperInfoVO>> pageList(WallpaperInfoPageReqDTO reqDTO){
        return ResultVO.success(wallpaperInfoService.pageList(reqDTO));
    }

    @Operation(summary = "添加壁纸信息")
    @PostMapping("/addWallpaperInfo")
    public ResultVO<Boolean> addWallpaperInfo(@RequestBody WallpaperAddReqDTO reqDTO){
        return wallpaperInfoService.addWallpaperInfo(reqDTO);
    }

    @Operation(summary = "修改壁纸信息")
    @PostMapping("/updateWallpaperInfo")
    public ResultVO<Boolean> updateWallpaperInfo(@RequestBody WallpaperUpdateReqDTO reqDTO){
        return wallpaperInfoService.updateWallpaperInfo(reqDTO);
    }

    @Operation(summary = "根据ID删除壁纸信息")
    @Parameter(name = "id", description = "壁纸ID", required = true)
    @DeleteMapping("/deleteById")
    public ResultVO<Boolean> deleteById(@RequestParam("id") Long id){
        wallpaperInfoService.removeById(id);
        return ResultVO.success(true);
    }

}
