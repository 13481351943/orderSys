package com.order.mapper;

import com.order.core.support.BaseMapper;
import com.order.entity.CookingInfoVO;
import com.order.entity.OrderSku;
import com.order.entity.OrderSkuCriteria;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface OrderSkuMapper extends BaseMapper<OrderSku> {
	List<CookingInfoVO> findMainOrderInfo();
	int getMainOrderPrice(Map map);
	int updateMainOrderPrice(Map map);
}