package com.order.service;

import com.order.core.support.IBaseService;
import com.order.entity.SysMenu;
import com.order.vo.MenuVO;

import java.util.List;

public interface ISysMenuService extends IBaseService<SysMenu> {

    Integer saveMenu(SysMenu sysMenu);

    Integer updateMenu(SysMenu sysMenu);

    Integer delMenu(String id);

    List<MenuVO> getMenuVOByUserId(String userId);

    List<MenuVO> getAllMenuVO();
}
