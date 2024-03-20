package com.business.service.advertising;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.controller.pc.advertising.dto.AdvAddReqDTO;
import com.business.controller.pc.advertising.dto.AdvPageReqDTO;
import com.business.controller.pc.advertising.dto.AdvUpdateReqDTO;
import com.business.controller.pc.advertising.vo.AdvertisingVO;
import com.business.model.dao.AdvertisingMapper;
import com.business.model.pojo.Advertising;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 广告信息表 service实现类
 */
@Service
public class AdvertisingServiceImpl extends ServiceImpl<AdvertisingMapper, Advertising> implements IAdvertisingService {
    @Resource
    private AdvertisingMapper advertisingMapper;


    /**
     * 分页查询广告信息
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<AdvertisingVO> pageList(AdvPageReqDTO reqDTO) {
        Page<AdvertisingVO> page = advertisingMapper.pageList(new Page<>(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    /**
     * 新增广告
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addAdv(AdvAddReqDTO reqDTO) {
        Advertising advertising = BeanUtil.copyProperties(reqDTO, Advertising.class);
        advertising.setCreateId(SecurityUtils.getLoginUserId());
        this.save(advertising);
        return ResultVO.success(true);
    }

    /**
     * 修改广告
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> updateAdv(AdvUpdateReqDTO reqDTO) {
        Advertising advertising = BeanUtil.copyProperties(reqDTO, Advertising.class);
        advertising.setUpdateId(SecurityUtils.getLoginUserId());
        this.updateById(advertising);
        return ResultVO.success(true);
    }

    /**
     * 获取下载壁纸前的广告信息
     * @return
     */
    @Override
    public MobileAdvertisingVO getDownloadBeforeAdv() {
        return advertisingMapper.getDownloadBeforeAdv();
    }

}
