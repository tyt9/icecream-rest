package com.parfait.icecream.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Topping {
    private String toppingId;
    private String toppingName;
    private int additionalPrice;
    private int stockQuantity;
}
