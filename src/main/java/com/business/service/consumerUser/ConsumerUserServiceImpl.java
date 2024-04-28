package com.business.service.consumerUser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.auth.entity.LoginUser;
import com.business.common.response.ResultVO;
import com.business.common.util.MD5Utils;
import com.business.common.util.SecurityUtils;
import com.business.common.util.SmsUtil;
import com.business.controller.mobile.consumerUser.dto.ConsumerUserUpdateReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginByPasswordReqDTO;
import com.business.controller.mobile.consumerUser.dto.LoginReqDTO;
import com.business.controller.mobile.consumerUser.dto.ResetPasswordReqDTO;
import com.business.controller.mobile.consumerUser.vo.ConsumerUserVO;
import com.business.controller.mobile.consumerUser.vo.LoginResultVO;
import com.business.model.dao.ConsumerUserMapper;
import com.business.model.dao.FavoritesMapper;
import com.business.model.pojo.ConsumerUser;
import com.business.model.pojo.Favorites;
import com.business.model.redis.LoginUserRedisDAO;
import com.business.service.favorites.IFavoritesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户 Service接口实现类
 * @Author yxf
 **/
@Service
public class ConsumerUserServiceImpl extends ServiceImpl<ConsumerUserMapper, ConsumerUser> implements IConsumerUserService {

    @Resource
    private LoginUserRedisDAO loginUserRedisDAO;

    @Resource
    private IFavoritesService favoritesService;


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
        //当前登录用户
        ConsumerUser user = null;
        //校验用户是否已存在
        if(!checkUserIsExists(reqDTO.getPhone())){
            //用户不存在，进行注册
            user = new ConsumerUser();
            user.setPhone(reqDTO.getPhone());
            user.setNickname(reqDTO.getPhone());
            user.setRegisterTime(LocalDateTime.now());
            this.save(user);

            //创建默认收藏夹
            this.createDefaultFavorites(user.getId());
        }else {
            //用户存在，查询出用户信息
            user = this.lambdaQuery().eq(ConsumerUser::getPhone, reqDTO.getPhone()).one();
            if(null == user){
                return ResultVO.error("Login failed: The phone number is not registered");
            }
        }

        return ResultVO.success(loginSuccess(user));
    }

    /**
     * 登录成功，创建token存入redis，并返回登录结果VO
     * @param user
     * @return
     */
    private LoginResultVO loginSuccess(ConsumerUser user){
        //登录成功，创建token，存入缓存
        String token = IdUtil.fastSimpleUUID();
        LoginUser loginUser = new LoginUser(user);
        loginUser.setToken(token);
        loginUserRedisDAO.set(token, loginUser, false);

        //修改最近登录时间
        user.setRecentLoginTime(LocalDateTime.now());
        this.updateById(user);

        //转换为登录响应结果
        LoginResultVO loginResultVO = BeanUtil.copyProperties(user, LoginResultVO.class);
        loginResultVO.setToken(token);

        return loginResultVO;
    }

    /**
     * 用户登录-密码登录
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<LoginResultVO> consumerLoginByPassword(LoginByPasswordReqDTO reqDTO) {
        if(StrUtil.isNotBlank(reqDTO.getPhone()) && StrUtil.isNotBlank(reqDTO.getPassword())){
            ConsumerUser user = this.lambdaQuery().eq(ConsumerUser::getPhone, reqDTO.getPhone())
                    .eq(ConsumerUser::getPassword, MD5Utils.MD5(reqDTO.getPassword())).one();
            if(null != user){
                return ResultVO.success(loginSuccess(user));
            }
            return ResultVO.error("Login failure: Account or password error");
        }

        return ResultVO.error("Login failed: Account or password cannot be empty");
    }

    /**
     * 用户注册后创建默认收藏夹
     * @param userId
     */
    private void createDefaultFavorites(Long userId){
        LocalDateTime now = LocalDateTime.now();
        List<Favorites> list = new ArrayList<>();
        list.add(new Favorites(userId, "風景壁紙", "", now));
        list.add(new Favorites(userId, "動物壁紙", "", now));
        list.add(new Favorites(userId, "かわいい壁紙", "", now));
        list.add(new Favorites(userId, "壁紙を手描きする", "", now));
        favoritesService.saveBatch(list);
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
     * 重设密码
     * @param reqDTO
     * @return
     */
    @Override
    public ResultVO<Boolean> resetPassword(ResetPasswordReqDTO reqDTO) {
        //校验密码长度
        if(StrUtil.isBlank(reqDTO.getPassword()) || reqDTO.getPassword().length() < 6){
            return ResultVO.error("Please enter a password with a length greater than or equal to 6");
        }
        //校验两次输入的密码是否一致
        if(!reqDTO.getPassword().equals(reqDTO.getAgainPassword())){
            return ResultVO.error("The passwords entered twice are inconsistent");
        }
        //校验验证码
        if(!SmsUtil.verifyCodePhone(SecurityUtils.getLoginUser().getPhoneAccount(), reqDTO.getVerifyCode())){
            return ResultVO.error("Error in verification code");
        }
        //修改密码
        this.lambdaUpdate().set(ConsumerUser::getPassword, MD5Utils.MD5(reqDTO.getPassword()))
                .eq(ConsumerUser::getId, SecurityUtils.getLoginUserId()).update();

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
