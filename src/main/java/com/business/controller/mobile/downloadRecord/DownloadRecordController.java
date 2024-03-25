package com.business.controller.mobile.downloadRecord;

import cn.hutool.core.bean.BeanUtil;
import com.business.common.constant.CommConstant;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.controller.mobile.downloadRecord.dto.DownloadRecordAddReqDTO;
import com.business.controller.mobile.wallpaper.dto.AddCollectReqDTO;
import com.business.controller.mobile.wallpaper.dto.MyCollectPageReqDTO;
import com.business.controller.mobile.wallpaper.dto.WallpaperPageReqDTO;
import com.business.controller.mobile.wallpaper.vo.MyCollectRespDTO;
import com.business.controller.mobile.wallpaper.vo.WallpaperDetailsInfoVO;
import com.business.controller.mobile.wallpaper.vo.WallpaperPageVO;
import com.business.model.dao.WallpaperCollectRecordMapper;
import com.business.model.pojo.WallpaperCollectRecord;
import com.business.service.advertising.IAdvertisingService;
import com.business.service.downloadRecord.IDownloadRecordService;
import com.business.service.wallpaper.IWallpaperInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

}
