package com.order.controller;

import com.order.common.util.UserUtils;
import com.order.core.support.BaseController;
import com.order.entity.SysRole;
import com.order.service.ISysRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/role")
@Api(tags = "系统角色控制器Api", description = "系统角色控制器提供基础增删改查和其他方法")
public class SysRoleController extends BaseController {

	@Autowired
	private ISysRoleService sysRoleService;
	@Autowired
	private UserUtils userUtils;

	@PostMapping("saveRole")
	public Integer saveRole(@RequestBody SysRole role){
		return sysRoleService.saveRole(role);
	}

	@PostMapping("updateRole")
	public Integer updateRole(@RequestBody SysRole role){
		return sysRoleService.updateRole(role);
	}

	@PostMapping("delRole")
	public Integer delRole(String roleId){
		return sysRoleService.delRole(roleId);
	}

	@PostMapping("getSysRoleByUserId")
	public List<SysRole> getSysRoleByUserId(String userId){
		return sysRoleService.getSysRoleByUserId(userId);
	}

	@PostMapping("getAllSysRole")
	public List<SysRole> getAllSysRole(){
		return sysRoleService.getAllSysRole();
	}

	@PostMapping("setRoleMenu")
	public Integer setRoleMenu(String roleId,List<String> menuIds){
		return sysRoleService.setRoleMenu(roleId,menuIds);
	}

	@PostMapping("delRoleMenu")
	public Integer delRoleMenu(String roleId,List<String> menuIds){
		return sysRoleService.delRoleMenu(roleId,menuIds);
	}





}
