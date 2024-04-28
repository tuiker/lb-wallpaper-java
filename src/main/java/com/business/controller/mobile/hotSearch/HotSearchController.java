package com.business.controller.mobile.hotSearch;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.business.common.constant.CommonNum;
import com.business.common.response.ResultVO;
import com.business.controller.mobile.hotSearch.dto.HotSearchSaveReqDTO;
import com.business.controller.mobile.hotSearch.vo.HotSearchVO;
import com.business.model.pojo.HotSearch;
import com.business.service.hotSearch.IHotSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mobile/hotSearch")
@Tag(name = "用户端 - 热搜关键词信息控制层")
public class HotSearchController {

    @Resource
    private IHotSearchService hotSearchService;

    @Operation(summary = "获取热搜关键词列表")
    @GetMapping("/findTopHotSearch")
    public ResultVO<List<HotSearchVO>> findTopHotSearch(){
        List<HotSearch> list = hotSearchService.lambdaQuery().orderByDesc(HotSearch::getSearchNum).last("LIMIT 10").list();
        return ResultVO.success(BeanUtil.copyToList(list, HotSearchVO.class));
    }

    @Operation(summary = "保存搜索关键词")
    @PostMapping("/saveSearchKeyword")
    public ResultVO<Boolean> saveSearchKeyword(@RequestBody HotSearchSaveReqDTO reqDTO){
        if(StrUtil.isBlank(reqDTO.getKeyword())){
            return ResultVO.success(true);
        }
        //查询该搜索关键词是否存在
        HotSearch hotSearch = hotSearchService.lambdaQuery().eq(HotSearch::getKeyword, reqDTO.getKeyword()).one();
        if(null == hotSearch){
            //不存在，新建
            hotSearch = new HotSearch();
            hotSearch.setKeyword(reqDTO.getKeyword());
            hotSearch.setSearchNum(CommonNum.ONE);
        }else {
            //存在，搜索次数+1
            hotSearch.setSearchNum(hotSearch.getSearchNum() + CommonNum.ONE);
        }
        //保存
        hotSearchService.saveOrUpdate(hotSearch);
        return ResultVO.success(true);
    }

}
