package com.business.controller.pc.wallpaper;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.business.common.constant.CommConstant;
import com.business.common.constant.CommonNum;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.controller.pc.wallpaper.dto.BatchAddWallpaperReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperAddReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperInfoPageReqDTO;
import com.business.controller.pc.wallpaper.dto.WallpaperUpdateReqDTO;
import com.business.controller.pc.wallpaper.vo.WallpaperInfoVO;
import com.business.model.pojo.Category;
import com.business.model.pojo.WallpaperInfo;
import com.business.service.category.ICategoryService;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/pc/wallpaper")
@Tag(name = "admin端 - 壁纸信息控制层")
public class WallPaperInfoController {

    @Resource
    private IWallpaperInfoService wallpaperInfoService;
    @Resource
    private ICategoryService categoryService;

    @Value("${lanBo.mobile.path:}")
    private String mobilePath;
    @Value("${lanBo.file.path:}")
    private String filePath;

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

    @Operation(summary = "根据壁纸文件目录批量新增壁纸信息")
    @PostMapping("/batchAddWallpaperToDatabase")
    public ResultVO<Boolean> batchAddWallpaperToDatabase(@RequestBody BatchAddWallpaperReqDTO reqDTO){
        LocalDateTime now = LocalDateTime.now();
        if (StrUtil.isBlank(reqDTO.getCategoryName())){
            return  ResultVO.error("壁纸分类名称不能为空");
        }
        if (StrUtil.isBlank(reqDTO.getFolderPath())){
            return  ResultVO.error("壁纸上级目录不能为空");
        }
        //根据壁纸分类名称查询壁纸分类信息
        Category category = categoryService.lambdaQuery().eq(Category::getName, reqDTO.getCategoryName()).one();
        if(null == category){
            return  ResultVO.error(String.format("找不到该壁纸分类:[%s]", reqDTO.getCategoryName()));
        }

        //获取壁纸上级目录
        File file = new File(reqDTO.getFolderPath());
        if(!file.exists() && !file.isDirectory()){
            return ResultVO.error("壁纸上级目录不存在");
        }

        //获取目录中的壁纸文件
        File[] files = file.listFiles();
        if(null == files || files.length < 1){
            return ResultVO.error("壁纸目录为空");
        }
        ArrayList<WallpaperInfo> wallpaperInfoList = new ArrayList<>();
        for (File wallpaperFile : files) {
            //获取文件名称，带文件扩展名
            String fullName = wallpaperFile.getName();
            if (fullName.endsWith(".jpg") || fullName.endsWith(".jpeg")) {
                //获取文件名称，不带文件扩展名
                String fileName = fullName.substring(0, fullName.indexOf("."));

                String fileUrl = mobilePath + wallpaperFile.getAbsolutePath();
                log.info(fileUrl);

                WallpaperInfo wallpaperInfo = new WallpaperInfo();
                wallpaperInfo.setName(fileName);
                wallpaperInfo.setCoverImage(fileUrl);
                wallpaperInfo.setImgUrlList(JSON.toJSONString(new String[]{fileUrl}));
                wallpaperInfo.setIsCollection(CommConstant.FLAG_FALSE);
                wallpaperInfo.setCategoryId(category.getId());
                wallpaperInfo.setDetails(fileName);
                wallpaperInfo.setCreateId((long) CommonNum.ONE);
                wallpaperInfo.setCreateTime(now);
                wallpaperInfoList.add(wallpaperInfo);
            }
        }

        wallpaperInfoService.saveBatch(wallpaperInfoList);

        return ResultVO.success(true);
    }
}
