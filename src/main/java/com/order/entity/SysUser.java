package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Byte status;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "head_img")
    private String headImg;

    /**
     * 状态  0：删除  1：正常
     */
    @Column(name = "is_valid")
    private Byte isValid;

    /**
     * 排序
     */
    @Column(name = "sort_num")
    private Integer sortNum;

    private String name;

    /**
     * 是否禁用:1启用;0-禁用
     */
    @Column(name = "is_effitive")
    private Integer isEffitive;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取状态  0：禁用   1：正常
     *
     * @return status - 状态  0：禁用   1：正常
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  0：禁用   1：正常
     *
     * @param status 状态  0：禁用   1：正常
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取部门ID
     *
     * @return dept_id - 部门ID
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
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
     * @return shop_id
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * @return head_img
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * @param headImg
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 获取状态  0：删除  1：正常
     *
     * @return is_valid - 状态  0：删除  1：正常
     */
    public Byte getIsValid() {
        return isValid;
    }

    /**
     * 设置状态  0：删除  1：正常
     *
     * @param isValid 状态  0：删除  1：正常
     */
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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