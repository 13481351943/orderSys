package com.order.mapper;

import java.util.List;

import com.order.core.support.BaseMapper;
import com.order.entity.OrderMain;

public interface OrderMainMapper extends BaseMapper<OrderMain> {
	int insertAndGetId(OrderMain orderMain);
	
	
}