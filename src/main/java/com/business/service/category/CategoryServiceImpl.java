package com.business.service.category;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
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
import com.business.model.dao.CategoryMapper;
import com.business.model.pojo.Category;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 壁纸分类 Service接口实现
 * @Author yxf
 **/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    /**
     * 分页查询壁纸分类列表
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<CategoryVO> pageList(CategoryPageReqDTO reqDTO) {
        if(StrUtil.isNotBlank(reqDTO.getName())){//模糊查询壁纸分类名称
            reqDTO.setName("%" + reqDTO.getName() + "%");
        }
        Page<CategoryVO> page = categoryMapper.pageList(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    /**
     * 添加壁纸分类
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addCategory(CategoryAddReqDTO reqDTO) {
        if(checkNameIsExists(reqDTO.getName(), null)){
            return ResultVO.success(false, "分类名称已存在！");
        }
        Category category = BeanUtil.copyProperties(reqDTO, Category.class);
        category.setCreateId(SecurityUtils.getLoginUserId());
        category.setCreateTime(LocalDateTime.now());
        this.save(category);
        return ResultVO.success(true);
    }

    /**
     * 修改壁纸分类
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> updateCategory(CategoryUpdateReqDTO reqDTO) {
        if(checkNameIsExists(reqDTO.getName(), reqDTO.getId())){
            return ResultVO.success(false, "分类名称已存在！");
        }
        Category category = BeanUtil.copyProperties(reqDTO, Category.class);
        category.setUpdateId(SecurityUtils.getLoginUserId());
        category.setUpdateTime(LocalDateTime.now());
        this.updateById(category);
        return ResultVO.success(true);
    }

    /**
     * 校验分类名称是否已存在
     * @param name 分类名称
     * @param id 分类ID
     * @return true：已存在，false：不存在
     */
    private boolean checkNameIsExists(String name, Long id){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getName, name);
        if(null != id){
            queryWrapper.ne(Category::getId, id);
        }
        long count = this.count(queryWrapper);
        return count > 0;
    }
}
