package com.example.demo.vo;

import java.io.Serializable;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/9/28 9:37
 */
public enum TestEnum implements ShowEnum,Serializable {
    STORE_SECURITY_SWITCH("security_setting", true, "门店安全设置设置开关"),
    STORE_NO_SWITCH("no_setting", true, "门店工单设置开关"),
    STORE_STOCK_SWITCH("stock_setting", true, "门店库存设置开关"),
    STORE_PRINT_SWITCH("print_setting", true, "门店打印设置开关"),
    STORE_MESSAGE_SWITCH("message_setting", true, "门店消息设置开关"),
    STORE_PERFORMANCE_SWITCH("performance_setting", true, "门店绩效设置开关"),
    STORE_FINANCE_SWITCH("finance_setting", true, "门店财务设置开关"),
    STORE_UNIVERSAL_SWITCH("universal_setting", true, "门店通用设置开关"),
    STORE_BOOK_SWITCH("book_setting", true, "门店预约设置开关"),
    STORE_WORKSHOP_SWITCH("workshop_setting", true, "门店车间设置开关"),

    STORE_CUSTOMER_CAR_SETTING_SWITCH("customer_car_setting", true, "门店客户车辆设置开关"),


    MULTI_DEVICE_LOGIN_LIMIT("multi_device_login_limit", false, "多设备同时登陆限制"),
    AUTO_LOGOUT_IDLE_TIME("auto_logout_idle_time", false, "闲时自动退出"),


    STORE_BO_SWITCH("bo_setting", true, "门店商机设置开关"),
    STORE_POINT_RULE_SWITCH("point_rule", true, "门店积分设置开关"),
    STORE_CARD_SETTING_SWITCH("card_setting", true, "门店卡项设置开关"),
    STORE_VISIT_SETTING_SWITCH("visit_setting", true, "门店回访设置开关"),
    STORE_POTENTIAL_CUSTOMER_SWITCH("potential_customer_setting", false, "门店潜客设置开关"),

    ;

    private String code;
    /**
     * 默认值
     */
    private Boolean defaultValue;

    private String desc;

    TestEnum(String code, Boolean defaultValue, String desc) {
        this.code = code;
        this.defaultValue = defaultValue;
        this.desc = desc;
    }


    @Override
    public String desc() {
        return desc;
    }


    @Override
    public int intValue() {
        return defaultValue ? 1 : 0;
    }


    @Override
    public String code() {
        return code;
    }
    public Serializable getValue() {
        return this.getValue();
    }

    public Boolean isDefaultValue() {
        return defaultValue;
    }

    public String getLogInfo(Boolean value) {
        return value ? "开启" : "关闭" + desc;
    }
}
