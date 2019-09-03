package com.order.vo;

import com.order.entity.OrderSku;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    private List<OrderSku> list;
}
