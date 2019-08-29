package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @Column(name = "role_id")
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 排序
     */
    @Column(name = "sort_num")
    private Integer sortNum;

    /**
     * 有效:0-否;1-是
     */
    @Column(name = "is_valid")
    private Integer isValid;

    /**
     * 修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

    /**
     * 是否禁用:1启用;0-禁用
     */
    @Column(name = "is_effitive")
    private Integer isEffitive;

    private static final long serialVersionUID = 1L;

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
     * 获取排序
     *
     * @return sort_num - 排序
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 设置排序
     *
     * @param sortNum 排序
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * 获取有效:0-否;1-是
     *
     * @return is_valid - 有效:0-否;1-是
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * 设置有效:0-否;1-是
     *
     * @param isValid 有效:0-否;1-是
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取修改时间
     *
     * @return edit_time - 修改时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置修改时间
     *
     * @param editTime 修改时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取是否禁用:1启用;0-禁用
     *
     * @return is_effitive - 是否禁用:1启用;0-禁用
     */
    public Integer getIsEffitive() {
        return isEffitive;
    }

    /**
     * 设置是否禁用:1启用;0-禁用
     *
     * @param isEffitive 是否禁用:1启用;0-禁用
     */
    public void setIsEffitive(Integer isEffitive) {
        this.isEffitive = isEffitive;
    }
}