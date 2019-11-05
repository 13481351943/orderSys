package com.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.order.entity.OrderSku;

public class OrderMainVO implements Serializable{
	/**
     * id
     */
    private Integer id;

   

    /**
     * 桌位id
     */
    private Integer tableId;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 真实价格
     */
    private BigDecimal realPrice;

    /**
     * 折扣价
     */
    private BigDecimal discountPrice;

    /**
     * 支付方式 0现金 1微信 2支付宝
     */
    private Integer payType;

    /**
     * 状态 0异常 1正常
     */
    private Integer status;

    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	private List<OrderSku> list;
	public List<OrderSku> getList() {
		return list;
	}
    public void setList(List<OrderSku> l) {
    	this.list = l;
    }

}
