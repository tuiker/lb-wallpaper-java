package com.business.controller.mobile.advTriggerRecord;

import com.business.common.response.ResultVO;
import com.business.controller.mobile.advTriggerRecord.dto.AdvTriggerRecordAddReqDTO;
import com.business.service.advTriggerRecord.IAdvTriggerRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("mobileAdvTriggerRecordController")
@RequestMapping("/mobile/advTriggerRecord")
@Tag(name = "用户端 - 广告触发记录控制层")
public class AdvTriggerRecordController {

    @Resource
    private IAdvTriggerRecordService advTriggerRecordService;


    @Operation(summary = "新增广告触发记录")
    @PostMapping("/addAdvTriggerRecord")
    public ResultVO<Boolean> addAdvTriggerRecord(@RequestBody AdvTriggerRecordAddReqDTO reqDTO){
        return advTriggerRecordService.addAdvTriggerRecord(reqDTO);
    }

}
