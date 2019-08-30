package com.order.service.impl;

import com.order.common.util.UUIDUtil;
import com.order.core.support.BaseServiceImpl;
import com.order.entity.*;
import com.order.mapper.SysMenuMapper;
import com.order.mapper.SysRoleMenuMapper;
import com.order.mapper.SysUserRoleMapper;
import com.order.service.ISysMenuService;
import com.order.vo.MenuVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu>  implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Integer saveMenu(SysMenu sysMenu){
        log.info("保存菜单目录 参数为：{}",sysMenu);
        sysMenu.setMenuId(UUIDUtil.generateID());
        return sysMenuMapper.insert(sysMenu);
    }

    @Override
    public Integer updateMenu(SysMenu sysMenu){
        log.info("修改菜单目录 参数为：{}",sysMenu);
        return sysMenuMapper.updateByPrimaryKey(sysMenu);
    }

    @Override
    public Integer delMenu(String id){
        log.info("删除菜单目录 参数为：{}",id);
        SysRoleMenuCriteria criteria = new SysRoleMenuCriteria();
        criteria.createCriteria().andMenuIdEqualTo(id);
        sysRoleMenuMapper.deleteByExample(criteria);
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MenuVO> getMenuVOByUserId(String userId){
        List<SysMenu> list = sysMenuMapper.listMenuByUserId(userId);
        return getMenuVO(list);
    }

    @Override
    public List<MenuVO> getAllMenuVO(){
        List<SysMenu> list = sysMenuMapper.selectAll();
        return getMenuVO(list);
    }


    private List<MenuVO> getMenuVO(List<SysMenu> sysMenus){
        List<MenuVO> menuVOS = new ArrayList<>();
        for(SysMenu sysMenu : sysMenus){
            if(StringUtils.isBlank(sysMenu.getParentId())){
                MenuVO vo = new MenuVO();
                BeanUtils.copyProperties(sysMenu,vo);
                List<MenuVO> sMenuVOS = new ArrayList<>();
                for(SysMenu sysMenu1 : sysMenus){
                    if(sysMenu1.getParentId().equals(sysMenu.getMenuId())){
                        MenuVO svo = new MenuVO();
                        BeanUtils.copyProperties(sysMenu1,svo);
                        List<MenuVO> tMenuVOS = new ArrayList<>();
                        for (SysMenu sysMenu2 : sysMenus){
                            if(sysMenu2.getParentId().equals(sysMenu1.getMenuId())){
                                MenuVO tvo = new MenuVO();
                                BeanUtils.copyProperties(sysMenu2,tvo);
                                tMenuVOS.add(tvo);
                            }
                        }
                        sMenuVOS.add(svo);
                    }
                }
                menuVOS.add(vo);
            }
        }
        return menuVOS;
    }
}
