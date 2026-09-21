package com.parfait.icecream.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderResultItem {
    private int detailId;
    private String productName;
    private List<OrderResultTopping> toppings;
}
