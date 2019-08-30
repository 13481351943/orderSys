package com.order.service.impl;

import com.order.entity.OrderMain;
import com.order.entity.OrderMainCriteria;
import com.order.entity.OrderSku;
import com.order.entity.OrderSkuCriteria;
import com.order.mapper.OrderMainMapper;
import com.order.mapper.OrderSkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<OrderSku> listOrderSkuByOrderId(Integer orderId){
        OrderSkuCriteria criteria = new OrderSkuCriteria();
        criteria.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderSku> list = orderSkuMapper.selectByExample(criteria);
        return list;
    }

















}
