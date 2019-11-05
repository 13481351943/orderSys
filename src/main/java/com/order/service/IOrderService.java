package com.order.service;

import java.math.BigDecimal;
import java.util.List;
import com.order.vo.*;
import com.order.entity.CookingInfoVO;
import com.order.entity.Food;
import com.order.entity.OrderMain;
import com.order.entity.OrderSku;
import com.order.entity.SysUser;
public interface IOrderService{
	Integer getOrderIdByTable(String userId ,String userName ,Integer tableId);
	//下单
	Integer saveOrderFood(Integer orderId ,List<Food> foods);
	
	Integer saveOrderFood(SysUser sysUser, OrderVO orderVO);
	
	
	List<OrderMain> listOrderMain(Integer userId,Integer tableId,Integer status);
	
	OrderVO listOrderSkuByOrderId(Integer orderId);
	
	Integer finishOrder(Integer orderId, Integer payType, BigDecimal realMoney);
	
	Integer updateOrder(Integer orderId,Integer orderSkuId);
		  
	Integer changeOrderState(Integer orderSkuId,Integer orderSkuState);
	
	CookingOrder listOrderSkuNeedCooking();
	
	CookingOrderMain listOrderMainNeedCooking();
	List<CookingInfoVO>findMainOrderInfo();
}
