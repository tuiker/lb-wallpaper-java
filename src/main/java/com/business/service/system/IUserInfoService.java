package com.business.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.common.vo.PageResult;
import com.business.controller.pc.system.dto.*;
import com.business.model.pojo.system.UserInfo;
import com.business.common.response.ResultVO;
import com.business.controller.pc.system.vo.UserInfoVO;
import com.business.controller.pc.system.vo.UserLoginRespVO;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 14:07
 * @Description: 用户信息表 服务接口
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 用户登录
     * @param reqDTO
     * @return
     */
    ResultVO<UserLoginRespVO> loginUser(UserLoginReqDTO reqDTO);

    /**
     * @Description 用户详情
     * @Author GaoLu
     * @Date 2023/10/19
     * @Return
     * @Param id
     **/
    UserInfoVO getUserInfoById(long id);

    /**
     * 分页查询用户列表
     * @param reqDTO
     * @return
     */
    PageResult<UserInfoVO> pageList(UserPageReqDTO reqDTO);

    /**
     * 添加系统用户
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addSysUser(SysUserAddReqDTO reqDTO);

    /**
     * 修改系统用户
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateSysUser(SysUserUpdateReqDTO reqDTO);

    /**
     * 修改系统用户密码
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateSysUserPassword(SysUserPasswordUpdateReqDTO reqDTO);
}
