package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "order_main")
public class OrderMain implements Serializable {
    /**
     * id
     */
	 @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 桌位id
     */
    @Column(name = "table_id")
    private Integer tableId;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 真实价格
     */
    @Column(name = "real_price")
    private BigDecimal realPrice;

    /**
     * 折扣价
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 支付方式 0现金 1微信 2支付宝
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 状态 0异常 1正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    private static final long serialVersionUID = 1L;

    @Override
	public String toString() {
		return "OrderMain [id=" + id + ", userId=" + userId + ", tableId=" + tableId + ", orderNum=" + orderNum
				+ ", price=" + price + ", realPrice=" + realPrice + ", discountPrice=" + discountPrice + ", payType="
				+ payType + ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", createBy=" + createBy + "]";
	}

	/**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取桌位id
     *
     * @return table_id - 桌位id
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * 设置桌位id
     *
     * @param tableId 桌位id
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取订单号
     *
     * @return order_num - 订单号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号
     *
     * @param orderNum 订单号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取真实价格
     *
     * @return real_price - 真实价格
     */
    public BigDecimal getRealPrice() {
        return realPrice;
    }

    /**
     * 设置真实价格
     *
     * @param realPrice 真实价格
     */
    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    /**
     * 获取折扣价
     *
     * @return discount_price - 折扣价
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 设置折扣价
     *
     * @param discountPrice 折扣价
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * 获取支付方式 0现金 1微信 2支付宝
     *
     * @return pay_type - 支付方式 0现金 1微信 2支付宝
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付方式 0现金 1微信 2支付宝
     *
     * @param payType 支付方式 0现金 1微信 2支付宝
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取状态 0异常 1正常
     *
     * @return status - 状态 0异常 1正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0异常 1正常
     *
     * @param status 状态 0异常 1正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}