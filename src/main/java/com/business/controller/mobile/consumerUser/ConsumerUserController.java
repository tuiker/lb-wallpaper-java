package com.business.controller.mobile.consumerUser;

import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.util.SmsUtil;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.consumerUser.dto.ConsumerUserUpdateReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginByPasswordReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginReqDTO;
import com.business.controller.mobile.consumerUser.dto.ResetPasswordReqDTO;
import com.business.controller.mobile.consumerUser.vo.ConsumerUserVO;
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

    @Operation(summary = "用户登录-验证码登录")
    @PostMapping("/consumerLogin")
    public ResultVO<LoginResultVO> consumerLogin(@RequestBody LoginReqDTO reqDTO){
        return consumerUserService.consumerLogin(reqDTO);
    }

    @Operation(summary = "用户登录-密码登录")
    @PostMapping("/consumerLoginByPassword")
    public ResultVO<LoginResultVO> consumerLoginByPassword(@RequestBody LoginByPasswordReqDTO reqDTO){
        return consumerUserService.consumerLoginByPassword(reqDTO);
    }

    @Operation(summary = "用户登出")
    @PostMapping("/consumerLoginOut")
    public ResultVO<Boolean> consumerLoginOut() {
        return consumerUserService.consumerLoginOut();
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/getUserInfo")
    public ResultVO<ConsumerUserVO> getUserInfo(){
        return ResultVO.success(consumerUserService.getUserInfo());
    }

    @Operation(summary = "修改用户信息")
    @PostMapping("/update")
    public ResultVO<Boolean> updateConsumerUserInfo(@RequestBody ConsumerUserUpdateReqDTO reqDTO){
        return consumerUserService.updateConsumerUserInfo(reqDTO);
    }

    @Operation(summary = "发送重设密码验证码到用户手机")
    @GetMapping("/sendResetPasswordSms")
    public ResultVO<Boolean> sendResetPasswordSms(){
        UniResponse res = SmsUtil.sendVerificationCode(SecurityUtils.getLoginUser().getPhoneAccount());
        return ResultVO.success(res.status == 200);
    }

    @Operation(summary = "重设密码")
    @PostMapping("/resetPassword")
    public ResultVO<Boolean> resetPassword(@RequestBody ResetPasswordReqDTO reqDTO){
        return consumerUserService.resetPassword(reqDTO);
    }

}
