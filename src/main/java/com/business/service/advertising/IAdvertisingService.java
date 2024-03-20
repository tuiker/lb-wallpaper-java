package com.business.service.advertising;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.controller.pc.advertising.dto.AdvAddReqDTO;
import com.business.controller.pc.advertising.dto.AdvPageReqDTO;
import com.business.controller.pc.advertising.dto.AdvUpdateReqDTO;
import com.business.controller.pc.advertising.vo.AdvertisingVO;
import com.business.model.pojo.Advertising;

import java.util.List;
import java.util.Map;

/**
 * 广告信息表 service类
 */
public interface IAdvertisingService extends IService<Advertising> {
    /**
     * 分页查询广告信息
     * @param reqDTO
     * @return
     */
    PageResult<AdvertisingVO> pageList(AdvPageReqDTO reqDTO);

    /**
     * 新增广告
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addAdv(AdvAddReqDTO reqDTO);

    /**
     * 修改广告
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateAdv(AdvUpdateReqDTO reqDTO);

    /**
     * 获取下载壁纸前的广告信息
     * @return
     */
    MobileAdvertisingVO getDownloadBeforeAdv();
}
