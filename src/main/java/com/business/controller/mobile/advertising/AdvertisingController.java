package com.business.controller.mobile.advertising;


import com.business.common.constant.CommConstant;
import com.business.common.response.ResultVO;
import com.business.controller.mobile.advertising.vo.MobileAdvertisingVO;
import com.business.service.advertising.IAdvertisingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController("mobileAdvertisingController")
@RequestMapping("/mobile/adv")
@Tag(name = "用户端 - 广告信息控制层")
public class AdvertisingController {

    @Resource
    private IAdvertisingService advertisingService;

    @Operation(summary = "获取下载壁纸前的广告信息")
    @GetMapping("/getDownloadBeforeAdv")
    public ResultVO<MobileAdvertisingVO> getDownloadBeforeAdv(){
        return ResultVO.success(advertisingService.getRandomAdv(null));
    }

}
