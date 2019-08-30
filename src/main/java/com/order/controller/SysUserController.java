package com.order.controller;

import com.order.common.util.RedisUtil;
import com.order.common.util.UUIDUtil;
import com.order.entity.SysUser;
import com.order.service.ISysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/sysUser")
@Api(tags = "系统用户控制器Api", description = "系统用户控制器提供基础增删改查和其他方法")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("saveUser")
    public Integer saveUser(@RequestBody SysUser sysUser){
        return sysUserService.saveUser(sysUser);
    }
    @PostMapping("updateUser")
    public Integer updateUser(@RequestBody SysUser sysUser){
        return sysUserService.updateUser(sysUser);
    }
    @PostMapping("delUser")
    public Integer delUser(String userId){
        return sysUserService.delUser(userId);
    }

    @PostMapping("setUserRole")
    public Integer setUserRole(String userId, List<String> roleIds){
        return sysUserService.setUserRole(userId,roleIds);
    }

    @PostMapping("removeUserRole")
    public Integer removeUserRole(String userId, List<String> roleIds){
        return sysUserService.removeUserRole(userId,roleIds);
    }

    @PostMapping("/noauth/login")
    public String login(String name,String password){
        SysUser sysUser = sysUserService.getSysUser(name);
        if(sysUser == null){
            return "";
        }
        if(!password.equals(sysUser.getPassword())){
            return "";
        }
        String key = UUIDUtil.generateID();
        redisUtil.set(key, sysUser,30*60L);
        return key;
    }






}
