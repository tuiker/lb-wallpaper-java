package com.business.service.downloadRecord;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordAddReqDTO;
import com.business.model.dao.DownloadRecordMapper;
import com.business.model.pojo.DownloadRecord;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 壁纸下载记录 Service接口实现类
 * @Author yxf
 **/
@Service
public class DownloadRecordServiceImpl extends ServiceImpl<DownloadRecordMapper, DownloadRecord> implements IDownloadRecordService {


    /**
     * 新增壁纸下载记录
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> addDownloadRecord(DownloadRecordAddReqDTO reqDTO) {
        DownloadRecord downloadRecord = BeanUtil.copyProperties(reqDTO, DownloadRecord.class);
        downloadRecord.setUserId(SecurityUtils.getLoginUserId());
        downloadRecord.setCreateTime(LocalDateTime.now());
        this.save(downloadRecord);
        return ResultVO.success(true);
    }
}
