package com.order.service;

import com.order.core.support.IBaseService;
import com.order.entity.SysRole;

import java.util.List;

public interface ISysRoleService extends IBaseService<SysRole> {

    Integer saveRole(SysRole role);

    Integer updateRole(SysRole role);

    Integer delRole(String roleId);

    Integer setRoleMenu(String roleId, List<String> menuIds);

    List<SysRole> getAllSysRole();

    List<SysRole> getSysRoleByUserId(String userId);

    Integer delRoleMenu(String roleId,List<String> menuIds);
}
