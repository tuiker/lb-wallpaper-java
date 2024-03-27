package com.business.controller.mobile.downloadRecord;

import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordAddReqDTO;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordPageReqDTO;
import com.business.controller.mobile.downloadRecord.vo.DownloadRecordPageVO;
import com.business.service.downloadRecord.IDownloadRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController("mobileDownloadRecordController")
@RequestMapping("/mobile/downloadRecord")
@Tag(name = "用户端 - 壁纸下载记录控制层")
public class DownloadRecordController {

    @Resource
    private IDownloadRecordService downloadRecordService;

    @Operation(summary = "新增壁纸下载记录")
    @PostMapping("/addDownloadRecord")
    public ResultVO<Boolean> addDownloadRecord(@RequestBody DownloadRecordAddReqDTO reqDTO) {
        return downloadRecordService.addDownloadRecord(reqDTO);
    }

    @Operation(summary = "分页查询我的壁纸下载记录")
    @PostMapping("/pageList")
    public ResultVO<PageResult<DownloadRecordPageVO>> pageList(DownloadRecordPageReqDTO reqDTO){
        return ResultVO.success(downloadRecordService.pageList(reqDTO));
    }

}
