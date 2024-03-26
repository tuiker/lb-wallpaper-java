package com.business.service.advTriggerRecord;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.controller.mobile.advTriggerRecord.dto.AdvTriggerRecordAddReqDTO;
import com.business.model.dao.AdvTriggerRecordMapper;
import com.business.model.pojo.AdvTriggerRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 广告触发记录 Service接口实现类
 * @Author yxf
 **/
@Service
public class AdvTriggerRecordServiceImpl extends ServiceImpl<AdvTriggerRecordMapper, AdvTriggerRecord> implements IAdvTriggerRecordService {

    /**
     * 新增广告触发记录
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addAdvTriggerRecord(AdvTriggerRecordAddReqDTO reqDTO) {
        AdvTriggerRecord record = BeanUtil.copyProperties(reqDTO, AdvTriggerRecord.class);
        record.setCreateTime(LocalDateTime.now());
        this.save(record);
        return ResultVO.success(true);
    }
}
