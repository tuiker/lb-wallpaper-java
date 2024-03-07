package com.business.service.category;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.category.dto.CategoryAddReqDTO;
import com.business.controller.pc.category.dto.CategoryPageReqDTO;
import com.business.controller.pc.category.dto.CategoryUpdateReqDTO;
import com.business.controller.pc.category.vo.CategoryVO;
import com.business.model.pojo.Category;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 壁纸分类 Service接口
 * @Author yxf
 **/
public interface ICategoryService extends IService<Category> {

    /**
     * 分页查询壁纸分类列表
     * @param reqDTO
     * @return
     */
    PageResult<CategoryVO> pageList(CategoryPageReqDTO reqDTO);

    /**
     * 添加壁纸分类
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addCategory(CategoryAddReqDTO reqDTO);

    /**
     * 修改壁纸分类
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateCategory(CategoryUpdateReqDTO reqDTO);
}
