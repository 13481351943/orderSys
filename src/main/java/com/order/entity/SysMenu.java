package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    @Id
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    private Integer status;

    @Column(name = "is_finish")
    private Integer isFinish;

    /**
     * 接口备注
     */
    @Column(name = "auth_name")
    private String authName;

    /**
     * 是否禁用:1启用;0-禁用
     */
    @Column(name = "is_effitive")
    private Integer isEffitive;

    private static final long serialVersionUID = 1L;

    /**
     * @return menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * 获取父菜单ID，一级菜单为0
     *
     * @return parent_id - 父菜单ID，一级菜单为0
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID，一级菜单为0
     *
     * @param parentId 父菜单ID，一级菜单为0
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单URL
     *
     * @return url - 菜单URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单URL
     *
     * @param url 菜单URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取授权(多个用逗号分隔，如：user:list,user:create)
     *
     * @return perms - 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置授权(多个用逗号分隔，如：user:list,user:create)
     *
     * @param perms 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 获取类型   0：目录   1：菜单   2：按钮
     *
     * @return type - 类型   0：目录   1：菜单   2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型   0：目录   1：菜单   2：按钮
     *
     * @param type 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取排序
     *
     * @return order_num - 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序
     *
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return is_finish
     */
    public Integer getIsFinish() {
        return isFinish;
    }

    /**
     * @param isFinish
     */
    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    /**
     * 获取接口备注
     *
     * @return auth_name - 接口备注
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * 设置接口备注
     *
     * @param authName 接口备注
     */
    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
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