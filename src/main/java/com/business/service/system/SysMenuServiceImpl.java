package com.business.service.system;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.business.common.constant.CommConstant;
import com.business.common.util.SecurityUtils;
import com.business.model.dao.system.SysMenuMapper;
import com.business.model.pojo.system.SysMenu;
import com.business.controller.pc.system.vo.SysMenuRespVO;
import com.business.service.system.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单或按钮权限 Service接口实现
 * @Author yxf
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    /**
     * 根据用户获取它的权限列表
     */
    @Override
    public List<SysMenuRespVO> getSysMenuList() {
        Long loginUserId = SecurityUtils.getLoginUserId();
        List<SysMenuRespVO> list;
        if(loginUserId == CommConstant.ADMIN_ID){
            list = BeanUtil.copyToList(this.lambdaQuery().orderByAsc(SysMenu::getSort).list(), SysMenuRespVO.class);
        }else {
            list = baseMapper.getSysMenuListByUserId(loginUserId);
        }
        return list;
    }

}
