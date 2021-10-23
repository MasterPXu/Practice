package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 连锁管理方式配置项:https://zhishiku.casstime.com/pages/viewpage.action?pageId=65360362
 * @author fayu.nie
 * @since 2021/2/24
 */
public enum UnionManageItem implements Serializable {
    /**
     * 配置项
     */
    SETTING_SECURITY(UnionManageType.SETTING,"setting_security","安全设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "chain_securitySettings"),
    SETTING_FINANCE(UnionManageType.SETTING,"setting_finance","财务设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "setting_finance"),
    SETTING_PRINT(UnionManageType.SETTING,"setting_print","打印设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "setting_print"),
    SETTING_PERFORMANCE(UnionManageType.SETTING,"setting_performance","绩效设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "setting_staff"),
    // 通用设置是总部单独存在的，不在各个门店做单独的控制
    // SETTING_UNIVERSAL(UnionManageType.SETTING,"setting_universal","通用设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "chain-basicSettings"),
    SETTING_STOCK(UnionManageType.SETTING,"setting_stock","库存设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "chain_StockConfiguration"),
    SETTING_MESSAGE(UnionManageType.SETTING,"setting_message","消息设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "chain_notice_setting"),
    SETTING_SERVICE_RECORD(UnionManageType.SETTING,"setting_service_record","工单设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "chain_serveConfiguration"),
    SETTING_BUSINESS(UnionManageType.SETTING,"setting_business","商机设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "business_setting"),
    SETTING_MARKETING_POINT(UnionManageType.SETTING,"setting_marketing_point","积分设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "point_setting"),
    SETTING_CUSTOMER_VISIT(UnionManageType.SETTING,"setting_customer_visit","回访设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "return_visit_setting"),
    SETTING_VIP_CARD(UnionManageType.SETTING,"setting_vip_card","卡项设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "cardItems_settings"),
    SETTING_CUSTOMER_CAR(UnionManageType.SETTING,"setting_customer_car","客户车辆设置",UnionManageMode.STORE, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "customer_car_setting"),
    SETTING_POTENTIAL_CUSTOMER(UnionManageType.SETTING,"setting_potential_customer","潜客设置",UnionManageMode.UNION, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "potential_customer_setting"),

    /**
     * 主数据
     */
    DATA_SERVICE_AND_LABOUR_TEMPLATE(UnionManageType.MAIN_DATA,"data_service_and_labour_template","工时/工时分类",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "setting_serve"),
    DATA_ADDITIONAL_PROJECT(UnionManageType.MAIN_DATA,"data_additional_project","附加项目",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "setting_serve"),
    // 暂时隐藏，改造完成后放开
    //DATA_STANDARD_LABOUR(UnionManageType.MAIN_DATA,"data_standard_labour","行业标准工时",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_standardLabourSetting"),
    DATA_PARTS_AND_CATEGORY(UnionManageType.MAIN_DATA,"data_parts_and_category","配件/配件分类",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_partsService"),
    DATA_SUPPLIERS_AND_CATEGORY(UnionManageType.MAIN_DATA,"data_suppliers_and_category","供应商/供应商类别",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "base_suppliers"),
    /** 不提供“引用赋能”选项 */
    DATA_CUSTOMER_AND_CAR_ETC(UnionManageType.MAIN_DATA,"data_customer_and_car_etc","客户/车辆/车辆等级/客户来源/客户分组/车辆分组/潜客咨询内容",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "customer_list"),
    DATA_POPULARIZING_CHANNEL(UnionManageType.MAIN_DATA,"data_popularizing_channel","推广渠道",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "channel"),
    DATA_INSURANCE_COMPANY(UnionManageType.MAIN_DATA,"data_insurance_company","保险公司",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "base_insuranceCompany"),
    // 暂时隐藏，改造完成后放开
    //DATA_CAR_CHECK_TEMPLATE(UnionManageType.MAIN_DATA,"data_car_check_template","车检模板",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_carCheck"),
    DATA_SERVICE_AND_CHARGE_TYPE(UnionManageType.MAIN_DATA,"data_service_and_charge_type","服务类型/收费类型",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_others"),
    DATA_FINANCE_IN_OUT_TYPE(UnionManageType.MAIN_DATA,"data_finance_in_out_type","收入类型/支出类型",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_income_outlay"),
    DATA_SETTLE_ACCOUNT(UnionManageType.MAIN_DATA,"data_settle_account","结算账户",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_settlement_account"),
    /** 不提供“引用赋能”选项 */
    DATA_TECHNICIAN_LEVEL(UnionManageType.MAIN_DATA,"data_technician_level","技师等级",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "technician_level"),
    /** 不提供“引用赋能”选项 */
    DATA_WORKER_GROUP(UnionManageType.MAIN_DATA,"data_worker_group","工作组",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "base_chain_employee"),

    // DATA_CARD_COUPON(UnionManageType.MAIN_DATA,"data_card_coupon","卡券",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE}, "marketing_couponList"),

    DATA_BUSINESS_SOURCE(UnionManageType.MAIN_DATA,"data_business_source","业务来源",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "chain_others"),

    DATA_VEHICLE_CHECK_TEMPLATE(UnionManageType.MAIN_DATA,"data_vehicle_check_template","车检模板",UnionManageMode.UNSET, new UnionManageMode[]{UnionManageMode.UNION,UnionManageMode.STORE,UnionManageMode.JOIN}, "serve_maintainReportList"),

    ;
    /**
     * 管理的是配置项还是主数据
     */
    private UnionManageType manageType;

    /**
     * code，不允许重复
     */
    private String code;
    /**
     * 描述
     */
    private String desc;
    /**
     * 默认管理模式
     */
    private UnionManageMode defaultMode;
    /**
     * 可选管理模式
     */
    private UnionManageMode[] allowedMode;
    /**
     * 对应功能的菜单code(用于前端页面跳转)
     */
    private String menuCode;

    UnionManageItem(UnionManageType manageType,String code, String desc,  UnionManageMode defaultMode, UnionManageMode[] allowedMode,String menuCode) {
        this.manageType = manageType;
        this.code = code;
        this.desc = desc;
        this.defaultMode = defaultMode;
        this.allowedMode = allowedMode;
        this.menuCode=menuCode;
    }

    @JsonCreator
    public static UnionManageItem of(String code){
        for (UnionManageItem item : UnionManageItem.values()) {
            if (item.getValue().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public boolean isAllowed(Integer manageMode) {
        return Arrays.stream(allowedMode).anyMatch(item->item.getCode().equals(manageMode));
    }

    public String getDesc() {
        return desc;
    }

    public UnionManageType getManageType() {
        return manageType;
    }

    public UnionManageMode getDefaultMode() {
        return defaultMode;
    }

    public UnionManageMode[] getAllowedMode() {
        return allowedMode;
    }

    @JsonValue
    public String getCode() {
        return code;
    }


    public Serializable getValue() {
        return code;
    }

    public String getMenuCode() {
        return menuCode;
    }
}
