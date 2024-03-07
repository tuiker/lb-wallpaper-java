package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.model.pojo.Category;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper extends MPJBaseMapper<Category> {

    Page<CategoryVO> pageList(Page<Category> page, @Param("reqDTO") CategoryPageReqDTO reqDTO);

}
