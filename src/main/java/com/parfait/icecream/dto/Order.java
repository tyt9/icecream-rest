package com.parfait.icecream.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {
    private int orderId;
    private int totalAmount;
    private LocalDateTime orderDateTime;
}
