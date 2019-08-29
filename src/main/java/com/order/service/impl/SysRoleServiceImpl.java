package com.order.service.impl;

import com.order.core.support.BaseServiceImpl;
import com.order.entity.SysRole;
import com.order.entity.SysRoleMenu;
import com.order.entity.SysUser;
import com.order.mapper.SysRoleMapper;
import com.order.mapper.SysRoleMenuMapper;
import com.order.mapper.SysUserMapper;
import com.order.mapper.SysUserRoleMapper;
import com.order.service.ISysRoleService;
import com.order.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRoleServiceImpl extends BaseServiceImpl<SysRole>  implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
}
