package com.business.controller.mobile.favorites;

import cn.hutool.core.bean.BeanUtil;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.favorites.dto.AddCollectReqDTO;
import com.business.controller.mobile.favorites.vo.FavoritesVO;
import com.business.controller.mobile.favorites.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.favorites.vo.MyCollectRespVO;
import com.business.model.pojo.Favorites;
import com.business.service.favorites.IFavoritesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mobile/favorites")
@Tag(name = "用户端 - 壁纸收藏夹控制层")
public class FavoritesController {

    @Resource
    private IFavoritesService favoritesService;



    @Operation(summary = "获取我的收藏夹基本信息集合")
    @GetMapping("/getMyFavorites")
    public ResultVO<List<FavoritesVO>> getMyFavorites(){
        List<Favorites> list = favoritesService.lambdaQuery().eq(Favorites::getUserId, SecurityUtils.getLoginUserId()).orderByDesc(Favorites::getCreateTime).list();
        return ResultVO.success(BeanUtil.copyToList(list, FavoritesVO.class));
    }

    @Operation(summary = "取消收藏壁纸")
    @PostMapping("/cancelCollect")
    public ResultVO<Boolean> cancelCollect(@RequestBody AddCollectReqDTO reqDTO) {
        return favoritesService.cancelCollect(reqDTO);
    }

    @Operation(summary = "收藏壁纸")
    @PostMapping("/addCollect")
    public ResultVO<Boolean> addCollect(@RequestBody AddCollectReqDTO reqDTO) {
        return favoritesService.addCollect(reqDTO);
    }

    @Operation(summary = "分页查询我的收藏壁纸列表")
    @GetMapping("/getMyCollect")
    public ResultVO<PageResult<MyCollectRespVO>> getMyCollect(MyCollectPageReqDTO reqDTO){
        return ResultVO.success(favoritesService.getMyCollect(reqDTO));
    }

}
