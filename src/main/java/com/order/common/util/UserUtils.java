package com.order.common.util;

import com.order.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用作从redis中获取用户信息
 * @author huangbin
 *
 */
@Component
public class UserUtils {

	@Autowired
	private RedisUtil redisUtil;

	public SysUser getSysUser(){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String token = request.getHeader("token");
		return getSysUserByRedis(token);
	}

	
	/**
	 * 通过redis获取用户信息
	 * @param key
	 * @return
	 */
	public SysUser getSysUserByRedis(String key) {
		if(StringUtils.isBlank(key)) {
			return null;
		}
		SysUser user = (SysUser) redisUtil.get(key);
		if(user == null) {
			return null;
		}
		return user;
	}
	
	/**
	 * 将用户信息放置入redis中 
	 * 可用作更新用户过期时间
	 * @param key
	 * @param user
	 */
	public void setSysUser2Redis(String key,SysUser user) {
		redisUtil.set(key, user,30*60L);
	}
	
	
	
	
	
	
	
	
	
}
