package com.business.controller.pc.category;

import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.service.category.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pc/category")
@Tag(name = "admin端 - 壁纸分类控制层")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @Operation(summary = "分页查询壁纸分类列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<CategoryVO>> pageList(CategoryPageReqDTO reqDTO){
        return ResultVO.success(categoryService.pageList(reqDTO));
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
        categoryService.removeById(id);
        return ResultVO.success(true);
    }
}
