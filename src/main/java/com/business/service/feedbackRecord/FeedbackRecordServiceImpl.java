package com.business.service.feedbackRecord;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.feedbackRecord.dto.FeedbackAddReqDTO;
import com.business.controller.pc.feedbackRecord.dto.FeedbackRecordPageReqDTO;
import com.business.controller.pc.feedbackRecord.vo.FeedbackRecordVO;
import com.business.model.dao.FeedbackRecordMapper;
import com.business.model.pojo.FeedbackRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户反馈记录 Service接口实现类
 * @Author yxf
 **/
@Service
public class FeedbackRecordServiceImpl extends ServiceImpl<FeedbackRecordMapper, FeedbackRecord> implements IFeedbackRecordService {


    /**
     * 新增用户反馈
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addFeedback(FeedbackAddReqDTO reqDTO) {
        FeedbackRecord record = BeanUtil.copyProperties(reqDTO, FeedbackRecord.class);
        record.setUserId(SecurityUtils.getLoginUserId());
        record.setCreateTime(LocalDateTime.now());
        this.save(record);
        return ResultVO.success(true);
    }


    /**
     * 分页查询反馈记录
     * @param reqDTO
     * @return
     */
    @Override
    public PageResult<FeedbackRecordVO> pageList(FeedbackRecordPageReqDTO reqDTO) {
        Page<FeedbackRecordVO> page = baseMapper.pageList(new Page(reqDTO.getPage(), reqDTO.getPageSize()), reqDTO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }
}
