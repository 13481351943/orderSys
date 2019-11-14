package com.order.controller;

import com.order.entity.*;
import com.order.common.util.*;
import com.order.vo.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.order.service.IOrderService;

import io.swagger.annotations.Api;

@RestController("/order")
@Api(tags = "订单控制器Api",description = "订单控制提供基础增删改查，及其他方法")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private UserUtils userUtils;
	
//	@PostMapping("getInfo")
//	public Integer getInfo() {
//		return 1;
//	}
//	
//	@PostMapping("getOrderId")
//	public Integer getOrderIdByTable(Integer tableId) {
//		SysUser sysUser = userUtils.getSysUser();
//		return orderService.getOrderIdByTable(sysUser.getUserId(),sysUser.getName(),tableId);
//	}
//	
//	@PostMapping("saveFoodOrder")
//	public Integer saveFoodOrder(Integer orderId,@RequestBody List<Food> foods) {
//		return orderService.saveOrderFood(orderId, foods);
//	}
//	
	@PostMapping("saveFoodOrderVO")
	public Integer saveFoodOrderVO(@RequestBody OrderVO orderVO) {
		
		return orderService.saveOrderFood(userUtils.getSysUser(),orderVO);
	}
	
	@PostMapping("listOrderMain")
	public List<OrderMain> listOrderMain(Integer userId,Integer tableId,Integer status){
		return orderService.listOrderMain(userId, tableId, status);
	}
	
	@PostMapping("listOrderSkuByOrderId")
	public OrderVO listOrderSkuByOrderId(Integer orderId) {
		return orderService.listOrderSkuByOrderId(orderId);
	}
	
	@PostMapping("finishOrder")
	public Integer finishOrder(Integer orderId, Integer payType, BigDecimal realMoney) {
		return orderService.finishOrder(orderId,payType,realMoney);
	}
	
	@PostMapping("updateOrder")
	public Integer updateOrder(Integer orderId , Integer orderSkuId) {	
		return orderService.updateOrder(orderId, orderSkuId);
	
	}
	/***
	 * 上菜，退菜
	 * @param orderSkuId
	 * @param orderSkuState
	 * @return
	 */
	@PostMapping("changeOrderSkuState")
	public Integer changeOrderState(Integer orderSkuId,Integer orderSkuState) {
		return orderService.changeOrderState(orderSkuId,orderSkuState); 
	}
	
	@PostMapping("listOrderSkuNeedCooking")
	public CookingOrder listOrderSkuNeedCooking(){
		return orderService.listOrderSkuNeedCooking();
	}
	
	
	@PostMapping("listOrderMainNeedCooking")
	public CookingOrderMain listOrderMainNeedCooking() {
		return orderService.listOrderMainNeedCooking();
	}
	
	@PostMapping("findMainOrderInfo")
	public List<CookingInfoVO> findMainOrderInfo(){
		return orderService.findMainOrderInfo();
	}
	
	@PostMapping("/upload")
	public String upload(@RequestBody MultipartFile file) {
		if(file.isEmpty()) {
			return "上传失败，请选择文件";
		}
		String fileName = file.getOriginalFilename();
		String filePath = "/Users/itinypocket/workspace/temp/";
		File dest = new File(filePath +fileName);
		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "上传失败";
	}
}
