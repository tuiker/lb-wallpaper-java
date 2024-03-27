package com.business.service.downloadRecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordAddReqDTO;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordPageReqDTO;
import com.business.controller.mobile.downloadRecord.vo.DownloadRecordPageVO;
import com.business.model.pojo.DownloadRecord;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 壁纸下载记录 Service接口
 * @Author yxf
 **/
public interface IDownloadRecordService extends IService<DownloadRecord> {

    /**
     * 新增壁纸下载记录
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addDownloadRecord(DownloadRecordAddReqDTO reqDTO);

    /**
     * 分页查询我的壁纸下载记录
     * @param reqDTO
     * @return
     */
    PageResult<DownloadRecordPageVO> pageList(DownloadRecordPageReqDTO reqDTO);

}
