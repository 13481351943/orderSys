package com.order.core.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import com.google.gson.Gson;
import com.order.common.util.ExceptionUtil;
import com.order.common.util.IPUtils;
import com.order.entity.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.core.annotation.SysLogger;
import com.order.service.ISysLogService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志，切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
	private static Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
	
	@Autowired
	ISysLogService sysLogService;

	@Pointcut("@annotation(com.order.core.annotation.SysLogger)")
	public void logPointCut() { 
		
	}
	
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		//保存日志
		try {
			saveSysLog(point, time);
		} catch (Exception e) {
			logger.debug("记录日志异常：{}", ExceptionUtil.getStackTraceAsString(e));
		}
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String description = method.getAnnotation(SysLogger.class).value();
		String name = method.getAnnotation(SysLogger.class).name();
		//请求的方法名
		String methodName = joinPoint.getTarget().getClass().getName()+
									":"+signature.getName();

		SysLog sysLog = createSystemLog("",methodName,description,name);
		//获取request
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		String ip = IPUtils.getIpAddr(request);
		sysLog.setIp(ip);

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = new Gson().toJson(args[0]);
			if(params.length() > 60000) {
				sysLog.setParams(org.apache.commons.lang3.StringUtils.substring(params, 0 ,60000));
			}else {
				sysLog.setParams(params);
			}
		}catch (Exception e){

		}

		sysLog.setTime(time);
		//保存系统日志
		sysLogService.insertSelective(sysLog);
	}
	
	private SysLog createSystemLog(String userName, String methodName, String description, String name) {
		SysLog sysLog = new SysLog();
		sysLog.setUsername(userName);
		sysLog.setMethod(methodName);
		sysLog.setOperation(description);
		sysLog.setCreateDate(new Date());

		return sysLog;
	}
    
}
