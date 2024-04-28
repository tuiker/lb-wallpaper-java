package com.business.service.hotSearch;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.favorites.dto.AddCollectReqDTO;
import com.business.controller.mobile.favorites.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.favorites.vo.MyCollectRespVO;
import com.business.model.pojo.Favorites;
import com.business.model.pojo.HotSearch;

/**
 * 热搜关键词信息 Service接口
 * @Author yxf
 **/
public interface IHotSearchService extends IService<HotSearch> {


}
