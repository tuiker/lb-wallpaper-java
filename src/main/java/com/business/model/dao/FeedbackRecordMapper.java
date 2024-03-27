package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.controller.pc.feedbackRecord.dto.FeedbackRecordPageReqDTO;
import com.business.controller.pc.feedbackRecord.vo.FeedbackRecordVO;
import com.business.model.pojo.FeedbackRecord;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackRecordMapper extends MPJBaseMapper<FeedbackRecord> {

    Page<FeedbackRecordVO> pageList(Page page, FeedbackRecordPageReqDTO reqDTO);

}
