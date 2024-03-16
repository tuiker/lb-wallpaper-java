package com.business.controller.mobile.consumerUser;

import com.business.common.response.ResultVO;
import com.business.common.util.SmsUtil;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.consumerUser.dto.LoginReqDTO;
import com.business.controller.mobile.consumerUser.vo.LoginResultVO;
import com.business.service.consumerUser.IConsumerUserService;
import com.unimtx.UniResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mobile/consumer")
@Tag(name = "用户端 - 用户控制层")
public class ConsumerUserController {

    @Resource
    private IConsumerUserService consumerUserService;

    @Operation(summary = "发送注册或登录验证码到用户手机")
    @GetMapping("/sendRegisterOrLoginSms")
    public ResultVO<Boolean> sendRegisterOrLoginSms(@RequestParam("phone") String phone){
        UniResponse res = SmsUtil.sendVerificationCode(phone);
        return ResultVO.success(res.status == 200);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/consumerLogin")
    public ResultVO<LoginResultVO> consumerLogin(@RequestBody LoginReqDTO reqDTO){
        return consumerUserService.consumerLogin(reqDTO);
    }

    @Operation(summary = "用户登出")
    @PostMapping("/consumerLoginOut")
    public ResultVO<Boolean> consumerLoginOut() {
        return consumerUserService.consumerLoginOut();
    }

}
