package com.business.controller.pc.feedbackRecord;

import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.feedbackRecord.dto.FeedbackAddReqDTO;
import com.business.controller.pc.feedbackRecord.dto.FeedbackRecordPageReqDTO;
import com.business.controller.pc.feedbackRecord.vo.FeedbackRecordVO;
import com.business.service.feedbackRecord.IFeedbackRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pc/feedback")
@Tag(name = "admin端 - 用户反馈控制层")
public class FeedbackRecordController {

    @Resource
    private IFeedbackRecordService feedbackRecordService;


    @Operation(summary = "分页查询反馈记录")
    @GetMapping("pageList")
    public ResultVO<PageResult<FeedbackRecordVO>> pageList(FeedbackRecordPageReqDTO reqDTO){
        return ResultVO.success(feedbackRecordService.pageList(reqDTO));
    }


}
