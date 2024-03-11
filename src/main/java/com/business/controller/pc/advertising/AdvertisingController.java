package com.business.controller.pc.advertising;


import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.pc.advertising.dto.AdvAddReqDTO;
import com.business.controller.pc.advertising.dto.AdvPageReqDTO;
import com.business.controller.pc.advertising.dto.AdvUpdateReqDTO;
import com.business.controller.pc.advertising.vo.AdvertisingVO;
import com.business.service.advertising.IAdvertisingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/pc/adv")
@Tag(name = "admin端 - 广告信息控制层")
public class AdvertisingController {

    @Resource
    private IAdvertisingService advertisingService;


    @Operation(summary = "广告列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<AdvertisingVO>> pageList(@ParameterObject AdvPageReqDTO reqDTO) {
        return ResultVO.success(advertisingService.pageList(reqDTO));
    }

    @Operation(summary = "新增广告")
    @PostMapping("/addAdv")
    public ResultVO<Boolean> addAdv(@RequestBody AdvAddReqDTO reqDTO) {
        return advertisingService.addAdv(reqDTO);
    }

    @Operation(summary = "修改广告")
    @PostMapping("/updateAdv")
    public ResultVO<Boolean> updateAdv(@RequestBody AdvUpdateReqDTO reqDTO) {
        return advertisingService.updateAdv(reqDTO);
    }

    @Operation(summary = "根据ID删除广告")
    @Parameter(name = "id", description = "广告ID", required = true)
    @DeleteMapping("/deleteById")
    public ResultVO<Boolean> deleteById(@RequestParam("id") Long id){
        advertisingService.removeById(id);
        return ResultVO.success(true);
    }

}
