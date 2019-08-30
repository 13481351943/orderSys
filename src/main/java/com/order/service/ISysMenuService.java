package com.order.service;

import com.order.entity.SysMenu;
import com.order.vo.MenuVO;

import java.util.List;

public interface ISysMenuService {

    Integer saveMenu(SysMenu sysMenu);

    Integer updateMenu(SysMenu sysMenu);

    Integer delMenu(String id);

    List<MenuVO> getMenuVOByUserId(String userId);

    List<MenuVO> getAllMenuVO();
}
