package com.business.controller.mobile.category;

import cn.hutool.core.bean.BeanUtil;
import com.business.common.response.ResultVO;
import com.business.controller.mobile.category.vo.CategoryVO;
import com.business.service.category.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("mobileCategoryController")
@RequestMapping("/mobile/category")
@Tag(name = "用户端 - 壁纸分类控制层")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @Operation(summary = "查询所有壁纸分类")
    @GetMapping("/listAll")
    public ResultVO<List<CategoryVO>> listAll(){
        return ResultVO.success(BeanUtil.copyToList(categoryService.list(), CategoryVO.class));
    }
}
