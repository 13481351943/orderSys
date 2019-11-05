package com.order.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class CookingInfoVO implements Serializable{
	 /**
     * 桌位id
     */
    @Column(name = "table_id")
    private Integer tableId;
    
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    
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
     * 备注
     */
    private String remark;
    
    private String name;
    
    private Integer type;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFootName() {
		return footName;
	}

	public void setFootName(String footName) {
		this.footName = footName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    
}
