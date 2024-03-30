package com.business.service.favorites;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.favorites.dto.AddCollectReqDTO;
import com.business.controller.mobile.favorites.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.favorites.vo.MyCollectRespVO;
import com.business.model.pojo.Favorites;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户收藏夹 Service接口
 * @Author yxf
 **/
public interface IFavoritesService extends IService<Favorites> {

    /**
     * 收藏壁纸
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addCollect(@RequestBody AddCollectReqDTO reqDTO);

    /**
     * 取消收藏壁纸
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> cancelCollect(AddCollectReqDTO reqDTO);

    /**
     * 根据壁纸ID校验用户是否已收藏该壁纸
     * @param wallpaperId 壁纸ID
     * @return
     */
    Boolean checkIsCollect(Long wallpaperId);

    /**
     * 分页查询我的收藏壁纸列表
     * @param reqDTO
     * @return
     */
    PageResult<MyCollectRespVO> getMyCollect(MyCollectPageReqDTO reqDTO);

}
