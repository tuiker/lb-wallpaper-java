package com.business.controller.mobile.wallpaper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.business.common.constant.CommConstant;
import com.business.common.enums.TriggerTypeEnums;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.advTriggerRecord.dto.AdvTriggerRecordAddReqDTO;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageInFavoritesReqDTO;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.service.advTriggerRecord.IAdvTriggerRecordService;
import com.business.service.advertising.IAdvertisingService;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Slf4j
@RestController
@RequestMapping("/mobile/wallpaper")
@Tag(name = "用户端 - 壁纸信息控制层")
public class WallPaperController {

    @Resource
    private IWallpaperInfoService wallpaperInfoService;

    @Resource
    private IAdvertisingService advertisingService;

    @Resource
    private IAdvTriggerRecordService advTriggerRecordService;

    @Operation(summary = "获取首页数据")
    @GetMapping("/getHomeData")
    public ResultVO<PageResult<WallpaperPageVO>> getHomeData(WallpaperPageReqDTO reqDTO){
        PageResult<WallpaperPageVO> result = wallpaperInfoService.pageList(reqDTO);

        if(CollectionUtil.isNotEmpty(result.getList())){
            //随机获取一个图片类型广告，放入壁纸集合中
            MobileAdvertisingVO randomAdv = advertisingService.getRandomAdv(null);
            if(null != randomAdv){
                WallpaperPageVO adv = BeanUtil.copyProperties(randomAdv, WallpaperPageVO.class);
                adv.setIsAdv(true);
                result.getList().add(adv);

                //另起线程保存广告展示记录
                new Thread(() -> {
                    AdvTriggerRecordAddReqDTO triggerRecordAddReqDTO = new AdvTriggerRecordAddReqDTO(adv.getId(), TriggerTypeEnums.SHOW.getCode());
                    advTriggerRecordService.addAdvTriggerRecord(triggerRecordAddReqDTO);
                }).start();
            }
        }

        return ResultVO.success(result);
    }

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

    @Operation(summary = "根据收藏夹ID分页查询该收藏夹中的壁纸")
    @GetMapping("/pageWallpaperInFavorites")
    public ResultVO<PageResult<WallpaperPageVO>> pageWallpaperInFavorites(WallpaperPageInFavoritesReqDTO reqDTO){
        return ResultVO.success(wallpaperInfoService.pageWallpaperInFavorites(reqDTO));
    }

}
