package com.order.service.impl;

import com.order.common.util.DateUtils;
import com.order.common.util.UUIDUtil;
import com.order.common.util.UserUtils;
import com.order.entity.CookingInfoVO;
import com.order.entity.Food;
import com.order.entity.FoodCriteria;
import com.order.entity.OrderMain;
import com.order.entity.OrderMainCriteria;
import com.order.entity.OrderSku;
import com.order.entity.OrderSkuCriteria;
import com.order.entity.SysUser;
import com.order.mapper.FoodMapper;
import com.order.mapper.OrderMainMapper;
import com.order.mapper.OrderSkuMapper;
import com.order.service.IOrderService;
import com.order.vo.CookingOrder;
import com.order.vo.CookingOrderMain;
import com.order.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderMainMapper orderMainMapper;
    @Autowired
    private OrderSkuMapper orderSkuMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
	private UserUtils userUtils;

    public List<OrderMain> listOrderMain(Integer userId,Integer tableId,Integer status){
        OrderMainCriteria criteria = new OrderMainCriteria();
        if(userId != null){
            criteria.createCriteria().andUserIdEqualTo(userId);
        }
        if(tableId != null){
            criteria.createCriteria().andTableIdEqualTo(tableId);
        }
        if(status != null){
            criteria.createCriteria().andStatusEqualTo(status);
        }
        return orderMainMapper.selectByExample(criteria);
    }


    public OrderVO listOrderSkuByOrderId(Integer orderId){
        OrderVO vo = new OrderVO();
        OrderMain orderMain = new OrderMain();
        orderMain.setId(orderId);
        orderMain = orderMainMapper.selectByPrimaryKey(orderMain);
//        System.out.println(orderMain.toString());
        BeanUtils.copyProperties(orderMain,vo);

        OrderSkuCriteria criteria = new OrderSkuCriteria();
        criteria.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderSku> list = orderSkuMapper.selectByExample(criteria);

        vo.setList(list);
        return vo;
    }

    public Integer finishOrder(Integer orderId, Integer payType, BigDecimal realMoney){
        OrderMain orderMain = orderMainMapper.selectByPrimaryKey(orderId);
        orderMain.setPayType(payType);
        orderMain.setRealPrice(realMoney);
        orderMain.setStatus(2);
        orderMain.setUpdateTime(new Date());
        return orderMainMapper.updateByPrimaryKeySelective(orderMain);
    }

    public Integer updateOrder(Integer orderId,Integer orderSkuId){
        
    	return null;
    }

    /**
     * 根据桌号查询（创建）OrderId
     * @return OrderId
     */
	@Override
	public Integer getOrderIdByTable(String userId ,String userName, Integer tableId) {
		// TODO Auto-generated method stub
		//根据tableId查询是否有未结账的订单
		List<OrderMain> list = selectOrderMainByTable(tableId);
		if(list==null || list.size()==0) {
			OrderMain orderMain = new OrderMain();
			orderMain.setTableId(tableId);
			orderMain.setOrderNum(UUIDUtil.generateID());
			orderMain.setUserId(userUtils.getSysUser().getUserId());
			orderMain.setCreateBy(userName);
			orderMainMapper.insert(orderMain);
			list = selectOrderMainByTable(tableId);
		}
		return list.get(0).getId();
	}

	private List<OrderMain> selectOrderMainByTable(Integer tableId){
		OrderMainCriteria criteria = new OrderMainCriteria();
		criteria.createCriteria().andTableIdEqualTo(tableId).andRealPriceIsNull();
		return orderMainMapper.selectByExample(criteria);
	}


	/**
	 * 根据订单号，下单
	 */
	@Override
	public Integer saveOrderFood(Integer orderId, List<Food> foods) {
		// TODO Auto-generated method stub
		//保存food记录
		OrderSku orderSku = new OrderSku();
		orderSku.setOrderId(orderId);
		for(int i = 0; i <foods.size(); i++) {
			orderSku.setFootId(foods.get(i).getId());
			orderSku.setFootName(foods.get(i).getName());
			orderSkuMapper.insert(orderSku);
		}
		return 200;
	}


	@Override
	public Integer saveOrderFood(SysUser sysUser,OrderVO orderVO) {
		// TODO Auto-generated method stub
		
//		List<OrderMain> listOrder = (List<OrderMain>) orderMainMapper.selectByPrimaryKey(orderVO.getId());
		OrderMain orderMain =new OrderMain(); 
		orderMain.setId(orderVO.getId());
		orderMain = orderMainMapper.selectByPrimaryKey(orderMain.getId());
		if(orderMain==null) { 
			//新订单
			System.out.println("新订单");
			orderMain = getNewOrderMain(sysUser,orderVO);
			orderMainMapper.insertAndGetId(orderMain);
			insertOrderVOList(orderVO,sysUser,orderMain);
		}else {
			//追加订单
			System.out.println("追加订单");
			orderMain = upOldOrderMain(orderVO,orderMain);
			orderMainMapper.updateByPrimaryKeySelective(orderMain);
			insertOrderVOList(orderVO,sysUser,orderMain);
		}
		return 200;
	}
	/**
	 * 将orderVO中List 的OrderSku写入数据库
	 * @param orderVO
	 * @param sysUser
	 * @param orderMain
	 */
	private void insertOrderVOList(OrderVO orderVO,SysUser sysUser,OrderMain orderMain) {
		for(int i=0;i<orderVO.getList().size();i++) {
			OrderSku orderSku = orderVO.getList().get(i);
			orderSku = setOrderSkuOrderMainInfo(sysUser,orderMain,orderSku);
			orderSkuMapper.insert(orderSku);
		}
	}
	/**
	 * 将OrderMain与OrderSku关联
	 * @param sysUser
	 * @param orderMain
	 * @param orderSku
	 * @return
	 */
	private OrderSku setOrderSkuOrderMainInfo(SysUser sysUser,OrderMain orderMain,OrderSku orderSku) {
		orderSku.setCreateBy(sysUser.getName());
		orderSku.setOrderId(orderMain.getId());
		orderSku.setCreateTime(DateUtils.current());
		orderSku.setUpdateTime(orderSku.getCreateTime());
		return orderSku;
	}
	/**
	 * 将订单更新
	 * @param orderVO
	 * @param orderMain
	 * @return
	 */
	private OrderMain upOldOrderMain(OrderVO orderVO,OrderMain orderMain) {
		orderMain.setPrice(orderVO.getPrice());
		orderMain.setUpdateTime(DateUtils.current());
		return orderMain;
	}
	/**
	 * 创建新的OrderMain
	 * @param sysUser
	 * @param orderVO
	 * @return
	 */
	private OrderMain getNewOrderMain(SysUser sysUser,OrderVO orderVO) {
		OrderMain orderMain = new OrderMain();
		
		orderMain.setUserId(sysUser.getUserId());
		orderMain.setTableId(orderVO.getTableId());
		orderMain.setOrderNum(UUIDUtil.generateID());
		orderMain.setPrice(orderVO.getPrice());
		orderMain.setCreateBy(sysUser.getName());
		orderMain.setCreateTime(DateUtils.current());
		orderMain.setUpdateTime(orderMain.getCreateTime());
		orderMain.setStatus(orderVO.getStatus());
		return orderMain;
	}


	@Override
	public Integer changeOrderState(Integer orderSkuId, Integer orderSkuState) {
		// TODO Auto-generated method stub
		OrderSku orderSku = new OrderSku();
		orderSku.setId(orderSkuId);
		orderSku.setStatus(orderSkuState);
		int backe = orderSkuMapper.updateByPrimaryKeySelective(orderSku);
		if(orderSkuState ==0) {
			//退菜，从新计算价格
			orderSku = orderSkuMapper.selectByPrimaryKey(orderSku.getId());
			return setOrderMainPrice(orderSku.getOrderId());
		}	
        return backe;
	}

	@Override
	public CookingOrderMain listOrderMainNeedCooking() {
		OrderMainCriteria criteria = new OrderMainCriteria();
		criteria.createCriteria().andRealPriceIsNull().andStatusEqualTo(1).andPayTypeIsNull();
		List<OrderMain> list = new ArrayList<OrderMain>();
		list = orderMainMapper.selectByExample(criteria);
		CookingOrderMain cookingOrderMain = new CookingOrderMain();
		List<OrderVO> cookingList = new ArrayList<OrderVO>();
		for(int i =0; i<list.size(); i++) {
			OrderVO orderVO = new OrderVO();
			BeanUtils.copyProperties(list.get(i),orderVO);
			OrderSkuCriteria orderSkuCriteria = new OrderSkuCriteria();
			orderSkuCriteria.createCriteria().andOrderIdEqualTo(orderVO.getId()).andStatusBetween(1, 2);
	        orderVO.setList( orderSkuMapper.selectByExample(orderSkuCriteria));
			cookingList.add(orderVO);
		}
		 cookingOrderMain.setCookingList(cookingList);
		 return cookingOrderMain;
	}
	
	
	@Override
	public CookingOrder listOrderSkuNeedCooking() {
		// TODO Auto-generated method stub
		CookingOrder cookingOrder = new CookingOrder();
		
		
		List<Integer> status = new ArrayList<Integer>();
		status.add(1);
		status.add(2);
		
		FoodCriteria barbecueCriteria = new FoodCriteria();
		//categoryId 为3时是烧烤
		barbecueCriteria.createCriteria().andCategoryIdEqualTo(3);
		List<Food> barbecueFoods =	foodMapper.selectByExample(barbecueCriteria);
		List<Integer> barbecueFoodId = new ArrayList<Integer>();
		for(int i=0;i<barbecueFoods.size();i++) {
			System.out.println("烧烤id："+barbecueFoods.get(i).getId());
			barbecueFoodId.add(barbecueFoods.get(i).getId());
		}
		
		FoodCriteria foodCriteria = new FoodCriteria();
		//categoryId 为3时是烧烤
		List<Integer> cookingId = new ArrayList<Integer>();
		cookingId.add(1);
		cookingId.add(2);
		cookingId.add(4);
		
		foodCriteria.createCriteria().andCategoryIdIn(cookingId);
		List<Food> cookingFoods =	foodMapper.selectByExample(foodCriteria);
		List<Integer> cookingFoodId = new ArrayList<Integer>();
		for(int j=0;j<cookingFoods.size();j++) {
			cookingFoodId.add(cookingFoods.get(j).getId());
		}
		
		
		OrderSkuCriteria criteria = new OrderSkuCriteria();
		criteria.createCriteria().andStatusIn(status).andFootIdIn(barbecueFoodId);
		cookingOrder.setBarbecueList(orderSkuMapper.selectByExample(criteria));
		
		OrderSkuCriteria cookingCriteria = new OrderSkuCriteria();
		cookingCriteria.createCriteria().andStatusIn(status).andFootIdIn(cookingFoodId);
		cookingOrder.setCookingList(orderSkuMapper.selectByExample(cookingCriteria));
		
		return cookingOrder ;
	}


	@Override
	public List<CookingInfoVO> findMainOrderInfo() {
		// TODO Auto-generated method stub
		return orderSkuMapper.findMainOrderInfo();
	}
	/**
	 * 根据skuOrderId 从新计算该单的总价
	 * @param orderId
	 */
	private int setOrderMainPrice(Integer orderId) {
		Map<String,Object> map= new HashMap<String,Object>();  
		map.put("orderId",orderId);  
		return orderSkuMapper.updateMainOrderPrice(map);
		
	}















}
