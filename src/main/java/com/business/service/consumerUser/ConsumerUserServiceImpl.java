package com.business.service.consumerUser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.auth.entity.LoginUser;
import com.business.common.response.ResultVO;
import com.business.common.util.SecurityUtils;
import com.business.common.util.SmsUtil;
import com.business.controller.mobile.consumerUser.dto.ConsumerUserUpdateReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginReqDTO;
import com.business.controller.mobile.consumerUser.vo.ConsumerUserVO;
import com.business.controller.mobile.consumerUser.vo.LoginResultVO;
import com.business.model.dao.ConsumerUserMapper;
import com.business.model.pojo.ConsumerUser;
import com.business.model.redis.LoginUserRedisDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户 Service接口实现类
 * @Author yxf
 **/
@Service
public class ConsumerUserServiceImpl extends ServiceImpl<ConsumerUserMapper, ConsumerUser> implements IConsumerUserService {

    @Resource
    private LoginUserRedisDAO loginUserRedisDAO;


    /**
     * 用户登录，首次登录直接注册并登录
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<LoginResultVO> consumerLogin(LoginReqDTO reqDTO) {
        //校验验证码
        if(!SmsUtil.verifyCodePhone(reqDTO.getPhone(), reqDTO.getVerifyCode())){
            return ResultVO.error("Error in verification code");
        }
        LocalDateTime now = LocalDateTime.now();
        //当前登录用户
        ConsumerUser user = null;
        //校验用户是否已存在
        if(!checkUserIsExists(reqDTO.getPhone())){
            //用户不存在，进行注册
            user = new ConsumerUser();
            user.setPhone(reqDTO.getPhone());
            user.setNickname(reqDTO.getPhone());
            user.setRegisterTime(now);
            this.save(user);
        }else {
            //用户存在，查询出用户信息
            user = this.lambdaQuery().eq(ConsumerUser::getPhone, reqDTO.getPhone()).one();
        }

        //登录成功，创建token，存入缓存
        String token = IdUtil.fastSimpleUUID();
        LoginUser loginUser = new LoginUser(user);
        loginUser.setToken(token);
        loginUserRedisDAO.set(token, loginUser, false);

        //修改最近登录时间
        user.setRecentLoginTime(now);
        this.updateById(user);

        //转换为登录响应结果
        LoginResultVO loginResultVO = BeanUtil.copyProperties(user, LoginResultVO.class);
        loginResultVO.setToken(token);
        return ResultVO.success(loginResultVO);
    }

    /**
     * 用户登出
     * @return
     */
    @Override
    public ResultVO<Boolean> consumerLoginOut() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if(null != loginUser){
            loginUserRedisDAO.remove(loginUser.getToken());
        }
        return ResultVO.success(true);
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public ConsumerUserVO getUserInfo() {
        ConsumerUser consumerUser = this.getById(SecurityUtils.getLoginUserId());
        return BeanUtil.copyProperties(consumerUser, ConsumerUserVO.class);
    }

    /**
     * 修改用户信息
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> updateConsumerUserInfo(ConsumerUserUpdateReqDTO reqDTO) {
        ConsumerUser consumerUser = BeanUtil.copyProperties(reqDTO, ConsumerUser.class);
        this.updateById(consumerUser);
        return ResultVO.success(true);
    }






    /**
     * 根据手机号校验用户是否已存在
     * @param phone 手机号
     * @return true：已存在，false：不存在
     */
    private Boolean checkUserIsExists(String phone){
        Long count = this.lambdaQuery().eq(ConsumerUser::getPhone, phone).count();
        return count > 0;
    }


}
