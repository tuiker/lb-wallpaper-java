package com.business.controller.pc.category;

import cn.hutool.core.bean.BeanUtil;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.model.pojo.WallpaperInfo;
import com.business.service.category.ICategoryService;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pc/category")
@Tag(name = "admin端 - 壁纸分类控制层")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @Resource
    private IWallpaperInfoService wallpaperInfoService;

    @Operation(summary = "分页查询壁纸分类列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<CategoryVO>> pageList(CategoryPageReqDTO reqDTO){
        return ResultVO.success(categoryService.pageList(reqDTO));
    }

    @Operation(summary = "查询所有壁纸分类")
    @GetMapping("/listAll")
    public ResultVO<List<CategoryVO>> listAll(){
        return ResultVO.success(BeanUtil.copyToList(categoryService.list(), CategoryVO.class));
    }

    @Operation(summary = "添加壁纸分类")
    @PostMapping("/addCategory")
    public ResultVO<Boolean> addCategory(@RequestBody CategoryAddReqDTO reqDTO){
        return categoryService.addCategory(reqDTO);
    }

    @Operation(summary = "修改壁纸分类")
    @PostMapping("/updateCategory")
    public ResultVO<Boolean> updateCategory(@RequestBody CategoryUpdateReqDTO reqDTO){
        return categoryService.updateCategory(reqDTO);
    }

    @Operation(summary = "根据ID删除分类")
    @Parameter(name = "id", description = "分类ID", required = true)
    @DeleteMapping("/deleteById")
    public ResultVO<Boolean> deleteById(@RequestParam("id") Long id){
        //查询是否有壁纸跟该分类进行关联，如果有则不准删除
        Long count = wallpaperInfoService.lambdaQuery().eq(WallpaperInfo::getCategoryId, id).count();
        if (count > 0){
            return ResultVO.error("该分类下有壁纸，不允许删除");
        }
        categoryService.removeById(id);
        return ResultVO.success(true);
    }
}
