package com.order.service;

import com.order.entity.SysUser;

import java.util.List;

public interface ISysUserService {

    Integer removeUserRole(String userId, List<String> roleIds);

    Integer saveUser(SysUser sysUser);

    Integer updateUser(SysUser sysUser);

    Integer delUser(String userId);

    Integer setUserRole(String userId, List<String> roleIds);

    SysUser getSysUser(String name);

}
