package com.order.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class OrderMainSku {
	/**
     * id
     */
    @Id
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 菜品id
     */
    @Column(name = "foot_id")
    private Integer footId;

    /**
     * 菜品名称
     */
    @Column(name = "foot_name")
    private String footName;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 状态 0：退菜 1：正常 2：加菜 3：已上菜 4：异常
     */
    private Integer status;

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
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取菜品id
     *
     * @return foot_id - 菜品id
     */
    public Integer getFootId() {
        return footId;
    }

    /**
     * 设置菜品id
     *
     * @param footId 菜品id
     */
    public void setFootId(Integer footId) {
        this.footId = footId;
    }

    /**
     * 获取菜品名称
     *
     * @return foot_name - 菜品名称
     */
    public String getFootName() {
        return footName;
    }

    /**
     * 设置菜品名称
     *
     * @param footName 菜品名称
     */
    public void setFootName(String footName) {
        this.footName = footName == null ? null : footName.trim();
    }

    /**
     * 获取数量
     *
     * @return num - 数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置数量
     *
     * @param num 数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取状态 0退菜 1正常 2加菜 3已完成
     *
     * @return status - 状态 0退菜 1正常 2加菜 3已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0退菜 1正常 2加菜 3已完成
     *
     * @param status 状态 0退菜 1正常 2加菜 3已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
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

}
