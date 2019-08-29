package com.order.controller;

import com.order.common.util.RedisUtil;
import com.order.core.annotation.SysLogger;
import com.order.core.support.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "系统用户控制器Api", description = "系统用户控制器提供基础增删改查和其他方法")
public class TestController extends BaseController {

	@Autowired
	private RedisUtil redisUtil;
	
	@GetMapping("/auth/test")
	public String testOne() {
		logger.info("ccc");
		return "success";
	}
	
	@GetMapping("/noauth/testTwo")
	public String testTwo() {
		return "success";
	}

	@PostMapping("/noauth/login")
	@SysLogger(value = "登录",name = "用户登录")
	public String login(String username) {
//		SysUser user = new SysUser();
//		user.setUserName(username);
//		redisUtil.set(username, user,30*60L);
		return "success";
	}
	
//	@PostMapping("/noauth/testst")
//	@ApiOperation("测试")
//	public String testst(@RequestBody TestVO vo) {
//		return "aaa";
//	}
	
	
}
