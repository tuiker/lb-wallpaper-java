package com.business.service.feedbackRecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.feedbackRecord.dto.FeedbackAddReqDTO;
import com.business.controller.pc.feedbackRecord.dto.FeedbackRecordPageReqDTO;
import com.business.controller.pc.feedbackRecord.vo.FeedbackRecordVO;
import com.business.model.pojo.FeedbackRecord;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户反馈记录 Service接口
 * @Author yxf
 **/
public interface IFeedbackRecordService extends IService<FeedbackRecord> {

    /**
     * 新增用户反馈
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addFeedback(FeedbackAddReqDTO reqDTO);

    /**
     * 分页查询反馈记录
     * @param reqDTO
     * @return
     */
    PageResult<FeedbackRecordVO> pageList(FeedbackRecordPageReqDTO reqDTO);

}
