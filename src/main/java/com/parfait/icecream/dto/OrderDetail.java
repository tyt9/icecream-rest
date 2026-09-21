package com.parfait.icecream.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDetail {
    private int detailId;
    private int orderId;
    private String productId;
}
