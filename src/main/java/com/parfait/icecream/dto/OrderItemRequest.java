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
public class OrderItemRequest {
    private String productId;
    private List<String> toppingIds;
}
