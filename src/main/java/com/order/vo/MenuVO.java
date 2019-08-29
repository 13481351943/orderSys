package com.order.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuVO {

    private String menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
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
    private Integer orderNum;

    private Integer status;

    /**
     * 接口备注
     */
    private String authName;

    /**
     * 是否禁用:1启用;0-禁用
     */
    private List<MenuVO> list;
}
