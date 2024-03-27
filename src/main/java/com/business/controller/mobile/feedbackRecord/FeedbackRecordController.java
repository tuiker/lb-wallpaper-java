package com.business.controller.mobile.feedbackRecord;

import com.business.common.response.ResultVO;
import com.business.controller.mobile.feedbackRecord.dto.FeedbackAddReqDTO;
import com.business.service.feedbackRecord.IFeedbackRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("mobileFeedbackRecordController")
@RequestMapping("/mobile/feedback")
@Tag(name = "用户端 - 用户反馈控制层")
public class FeedbackRecordController {

    @Resource
    private IFeedbackRecordService feedbackRecordService;


    @Operation(summary = "新增用户反馈")
    @PostMapping("/addFeedback")
    public ResultVO<Boolean> addFeedback(@RequestBody FeedbackAddReqDTO reqDTO){
        return feedbackRecordService.addFeedback(reqDTO);
    }

}
