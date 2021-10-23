package com.example.demo.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/8/16 14:01
 */
@Data
@Valid
public class User {
    Long id;
    String name;
    Integer age;
    String address;
    private Integer creditDateCount;
    @DecimalMin(value = "0.01", message = "调拨数量最小为：0.01")
    private BigDecimal qty;
}
