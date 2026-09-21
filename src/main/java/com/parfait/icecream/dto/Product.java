package com.parfait.icecream.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {

    private String productId;
    private String productName;
    private int price;
    private int stockQuantity;

}
