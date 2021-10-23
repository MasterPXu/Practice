package com.example.demo.vo;

import java.io.Serializable;

/**
 * 连锁管理模式: https://zhishiku.casstime.com/pages/viewpage.action?pageId=65360362
 * @author fayu.nie
 * @since 2021/2/24
 */
public enum UnionManageMode implements Serializable {
    /**
     * 还未设置管理模式（管理模式仅允许创建门店后设置一次）
     */
    UNSET(0,"未设置"),
    /**
     * 此管理模式表示连锁所有门店用一份数据或配置，如果产生了增删改，则修改的是同一份数据，所有门店同步生效
     */
    UNION(1,"连锁管控"),
    /**
     * 门店数据完全独立，不与其他门店共享信息
     */
    STORE(2,"门店自治"),
    /**
     * 各个门店可以查看和引用连锁设置的数据，但不能对数据进行任何修改
     * 门店可以自己新建数据，仅门店自己使用，A店不可查看和使用B店的数据
     */
    JOIN(3,"引用赋能");
    ;

    private Integer code;

    private String desc;

    UnionManageMode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UnionManageMode of(Integer code){
        for (UnionManageMode item : UnionManageMode.values()) {
            if (code.equals(item.getValue())) {
                return item;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public Serializable getValue() {
        return code;
    }
}
