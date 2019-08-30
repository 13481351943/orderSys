package com.order.service.impl;

import com.order.common.util.UUIDUtil;
import com.order.core.support.BaseServiceImpl;
import com.order.entity.*;
import com.order.mapper.SysRoleMapper;
import com.order.mapper.SysRoleMenuMapper;
import com.order.mapper.SysUserMapper;
import com.order.mapper.SysUserRoleMapper;
import com.order.service.ISysRoleService;
import com.order.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
@Slf4j
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole>  implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Integer saveRole(SysRole role){
        role.setRoleId(UUIDUtil.generateID());
        return sysRoleMapper.insertSelective(role);
    }

    @Override
    public Integer updateRole(SysRole role){
        return sysRoleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer delRole(String roleId){
        SysRoleMenuCriteria roleMenuCriteria = new SysRoleMenuCriteria();
        roleMenuCriteria.createCriteria().andRoleIdEqualTo(roleId);
        sysRoleMenuMapper.deleteByExample(roleMenuCriteria);

        SysUserRoleCriteria userRoleCriteria = new SysUserRoleCriteria();
        userRoleCriteria.createCriteria().andRoleIdEqualTo(roleId);
        sysUserRoleMapper.deleteByExample(userRoleCriteria);

        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public List<SysRole> getSysRoleByUserId(String userId){
        return sysRoleMapper.getSysRoleByUserId(userId);
    }

    @Override
    public List<SysRole> getAllSysRole(){
        return sysRoleMapper.selectAll();
    }

    @Override
    public Integer setRoleMenu(String roleId,List<String> menuIds){
        for(String menuId : menuIds){
            //todo 这里应该检查一下 是否存在
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setId(UUIDUtil.generateID());
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(roleId);
            sysRoleMenuMapper.insertSelective(roleMenu);
        }
        return 1;
    }

    @Override
    public Integer delRoleMenu(String roleId,List<String> menuIds){
        for(String menuId : menuIds){
            //todo 这里应该检查一下 是否存在
           SysRoleMenuCriteria criteria = new SysRoleMenuCriteria();
           criteria.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId);
           sysRoleMenuMapper.deleteByExample(criteria);
        }
        return 1;
    }





}
