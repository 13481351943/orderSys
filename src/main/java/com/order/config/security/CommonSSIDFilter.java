package com.order.config.security;

import com.alibaba.fastjson.JSONObject;
import com.order.common.enmus.ResponCodeEnmu;
import com.order.common.result.Message;
import com.order.common.util.UserUtils;
import com.order.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户身份验证
 * @author huangbin
 *
 */
@Component
public class CommonSSIDFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserUtils userUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String key = request.getHeader("token");
		System.out.println("token:"+key);
		SysUser user = userUtils.getSysUserByRedis(key);
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,x-requested-with, token");
		response.addHeader("Access-Control-Max-Age", "1800");
		if(user == null) {
			returnError(response);
			return;
		}
		updateSsidTime(key,user);
		filterChain.doFilter(request, response);
	}
	
	public void updateSsidTime(String key, SysUser user){
		userUtils.setSysUser2Redis(key, user);
	}
	
	/**
	 * Can be overridden in subclasses for custom filtering control,
	 * returning {@code true} to avoid filtering of the given request.
	 * <p>The default implementation always returns {@code false}.
	 * @param request current HTTP request
	 * @return whether the given request should <i>not</i> be filtered
	 * @throws ServletException in case of errors
	 */
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String url = request.getRequestURI();
		//swagger
		if(StringUtils.contains(url, "/swagger"))
			return true;
		//静态资源
		if(StringUtils.contains(url, ".css"))
			return true;
		if(StringUtils.contains(url, ".js"))
			return true;
		if(StringUtils.contains(url, ".jpg"))
			return true;
		if(StringUtils.contains(url, ".png"))
			return true;
		if(StringUtils.contains(url, ".ico"))
			return true;
		if(StringUtils.contains(url, "/api"))
			return true;
		if(StringUtils.contains(url, ".html"))
			return true;
		//不需验证资源
		if(StringUtils.contains(url, "/noauth/"))
			return true;
		return false;
	}
	
	public void returnError(HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Message message = Message.build(ResponCodeEnmu.NO_LOGIN.getCode(), "未登录", "未登录");
		String resultStr = JSONObject.toJSONString(message);
		response.getWriter().write(resultStr);
		response.getWriter().flush();
	}
	
	
}
