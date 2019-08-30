package com.order.service.impl;

import com.order.common.util.UUIDUtil;
import com.order.core.support.BaseServiceImpl;
import com.order.entity.SysUser;
import com.order.entity.SysUserRole;
import com.order.entity.SysUserRoleCriteria;
import com.order.mapper.SysUserMapper;
import com.order.mapper.SysUserRoleMapper;
import com.order.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserServiceImpl extends BaseServiceImpl<SysUser>  implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    public Integer saveUser(SysUser sysUser){
        sysUser.setUserId(UUIDUtil.generateID());
        return sysUserMapper.insertSelective(sysUser);
    }

    public Integer updateUser(SysUser sysUser){
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    public Integer delUser(String userId){
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    public Integer setUserRole(String userId, List<String> roleIds){
        for(String id : roleIds){
            SysUserRole userRole = new SysUserRole();
            userRole.setId(UUIDUtil.generateID());
            userRole.setRoleId(id);
            userRole.setUserId(userId);
            sysUserRoleMapper.insertSelective(userRole);
        }
        return 1;
    }

    public Integer removeUserRole(String userId, List<String> roleIds){
        for(String id : roleIds){
            SysUserRoleCriteria criteria = new SysUserRoleCriteria();
            criteria.createCriteria().andRoleIdEqualTo(id).andUserIdEqualTo(userId);
            sysUserRoleMapper.deleteByExample(criteria);
        }
        return 1;
    }





}
