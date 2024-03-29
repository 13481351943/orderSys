package com.order.service.impl;

import com.order.core.support.BaseMapper;
import com.order.entity.SysLog;
import com.order.mapper.SysLogMapper;
import com.order.service.ISysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements ISysLogService{
	
	private static Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);

	private static final String BASE_MESSAGE = "系统化模块类SysLogServiceImpl增删改查";

	@Autowired
	SysLogMapper sysLogMapper;
	
	protected BaseMapper<SysLog> getBaseMapper() {
		return this.sysLogMapper;
	}

	protected String getBaseMessage() {
		return BASE_MESSAGE;
	}

	protected Logger getLogger() {
		return logger;
	}
	
	@Override
	public Integer save(SysLog sysLog) {
		Integer count = sysLogMapper.insertSelective(sysLog);
		return count;
	}
}
