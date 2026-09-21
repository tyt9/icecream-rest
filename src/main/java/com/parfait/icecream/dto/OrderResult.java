package com.parfait.icecream.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderResult {
    private int orderId;
    private LocalDateTime orderDateTime;
    private int totalAmount;
    private List<OrderResultItem> items;
}
