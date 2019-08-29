package com.order.service.impl;

import com.order.core.support.BaseServiceImpl;
import com.order.entity.SysUser;
import com.order.mapper.SysUserMapper;
import com.order.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysUserServiceImpl extends BaseServiceImpl<SysUser>  implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
}
