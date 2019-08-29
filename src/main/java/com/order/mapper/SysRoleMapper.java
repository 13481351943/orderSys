package com.order.mapper;

import com.order.core.support.BaseMapper;
import com.order.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getSysRoleByUserId(@Param("userId")String userId);
}