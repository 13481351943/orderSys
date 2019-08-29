package com.order.mapper;

import com.order.core.support.BaseMapper;
import com.order.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listMenuByUserId(@Param("userId")String userId);
}