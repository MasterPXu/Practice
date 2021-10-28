package com.example.demo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/8/16 14:03
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SellerGoods {
    Long id;
    @NonNull String sellerName;
    private Integer creditLimitDay;
}
