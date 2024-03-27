package com.business.service.feedbackRecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.controller.mobile.feedbackRecord.dto.FeedbackAddReqDTO;
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

}
