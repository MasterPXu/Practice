package com.example.demo.vo;

import lombok.Getter;

import java.io.Serializable;

/**
 * 连锁管理方式分类，对于设置项和主数据有多种管理模式 #UnionManageMode
 * @author fayu.nie
 * @since 2021/2/24
 */
public enum UnionManageType implements Serializable {
    /**
     * 设置项的管理方式（如打印设置、工单设置）
     */
    SETTING(1,"设置项"),
    /**
     * 主数据的管控方式（如工时、配件）
     */
    MAIN_DATA(2,"主数据");
    ;
    @Getter
    private Integer code;

    private String desc;

    UnionManageType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UnionManageType of(Integer code){
        for (UnionManageType item : UnionManageType.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }


}
