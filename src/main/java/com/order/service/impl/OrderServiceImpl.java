package com.order.service.impl;

import com.order.entity.OrderMain;
import com.order.entity.OrderMainCriteria;
import com.order.entity.OrderSku;
import com.order.entity.OrderSkuCriteria;
import com.order.mapper.OrderMainMapper;
import com.order.mapper.OrderSkuMapper;
import com.order.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderMainMapper orderMainMapper;
    @Autowired
    private OrderSkuMapper orderSkuMapper;

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
        OrderMain orderMain = orderMainMapper.selectByPrimaryKey(orderId);
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
        orderMain.setStatus(1);
        orderMain.setUpdateTime(new Date());
        return orderMainMapper.updateByPrimaryKeySelective(orderMain);
    }

    public Integer updateOrder(Integer orderId,Integer orderSkuId){
        return null;
    }

















}
