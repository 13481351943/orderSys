package com.order.controller;

import com.order.common.util.UserUtils;
import com.order.core.support.BaseController;
import com.order.entity.SysMenu;
import com.order.service.ISysMenuService;
import com.order.vo.MenuVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/menu")
@Api(tags = "系统目录控制器Api", description = "系统目录控制器提供基础增删改查和其他方法")
public class SysMenuController extends BaseController {

	@Autowired
	private ISysMenuService sysMenuService;
	@Autowired
	private UserUtils userUtils;

	@PostMapping("saveMenu")
	public Integer saveMenu(SysMenu sysMenu){
		return sysMenuService.saveMenu(sysMenu);
	}

	@PostMapping("updateMenu")
	public Integer updateMenu(SysMenu sysMenu){
		return sysMenuService.updateMenu(sysMenu);
	}

	@PostMapping("delMenu")
	public Integer delMenu(String id){
		return sysMenuService.delMenu(id);
	}

	@PostMapping("getMenuVOByUserId")
	public List<MenuVO> getMenuVOByUserId(){
		String userId = userUtils.getSysUser().getUserId();
		return sysMenuService.getMenuVOByUserId(userId);
	}

	@PostMapping("getAllMenuVO")
	public List<MenuVO> getAllMenuVO(){
		return sysMenuService.getAllMenuVO();
	}

}
