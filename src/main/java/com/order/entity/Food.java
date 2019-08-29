package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "food")
public class Food implements Serializable {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 类别id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 类型 0小 1正常 2大
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 折扣价
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 销售量
     */
    private Integer sales;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 0已删除 1正常 2售罄
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
     * 获取类别id
     *
     * @return category_id - 类别id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别id
     *
     * @param categoryId 类别id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取类型 0小 1正常 2大
     *
     * @return type - 类型 0小 1正常 2大
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 0小 1正常 2大
     *
     * @param type 类型 0小 1正常 2大
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * 获取销售量
     *
     * @return sales - 销售量
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置销售量
     *
     * @param sales 销售量
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取状态 0已删除 1正常 2售罄
     *
     * @return status - 状态 0已删除 1正常 2售罄
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0已删除 1正常 2售罄
     *
     * @param status 状态 0已删除 1正常 2售罄
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