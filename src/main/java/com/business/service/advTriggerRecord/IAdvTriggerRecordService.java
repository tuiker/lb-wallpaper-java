package com.business.service.advTriggerRecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.controller.mobile.advTriggerRecord.dto.AdvTriggerRecordAddReqDTO;
import com.business.model.pojo.AdvTriggerRecord;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 广告触发记录 Service接口
 * @Author yxf
 **/
public interface IAdvTriggerRecordService extends IService<AdvTriggerRecord> {

    /**
     * 新增广告触发记录
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addAdvTriggerRecord(AdvTriggerRecordAddReqDTO reqDTO);

}
