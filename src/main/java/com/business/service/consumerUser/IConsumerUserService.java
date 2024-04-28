package com.business.service.consumerUser;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.response.ResultVO;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.consumerUser.dto.ConsumerUserUpdateReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginByPasswordReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginReqDTO;
import com.business.controller.mobile.consumerUser.dto.ResetPasswordReqDTO;
import com.business.controller.mobile.consumerUser.vo.ConsumerUserVO;
import com.business.controller.mobile.consumerUser.vo.LoginResultVO;
import com.business.model.pojo.ConsumerUser;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户 Service接口
 * @Author yxf
 **/
public interface IConsumerUserService extends IService<ConsumerUser> {

    /**
     * 用户登录，首次登录直接注册并登录
     * @param reqDTO
     * @return
     */
    ResultVO<LoginResultVO> consumerLogin(LoginReqDTO reqDTO);

    /**
     * 用户登录-密码登录
     * @param reqDTO
     * @return
     */
    ResultVO<LoginResultVO> consumerLoginByPassword(LoginByPasswordReqDTO reqDTO);

    /**
     * 用户登出
     * @return
     */
    ResultVO<Boolean> consumerLoginOut();

    /**
     * 获取用户信息
     * @return
     */
    ConsumerUserVO getUserInfo();

    /**
     * 修改用户信息
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateConsumerUserInfo(ConsumerUserUpdateReqDTO reqDTO);

    /**
     * 重设密码
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> resetPassword(@RequestBody ResetPasswordReqDTO reqDTO);

}
