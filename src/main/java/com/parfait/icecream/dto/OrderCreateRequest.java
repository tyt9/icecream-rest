package com.parfait.icecream.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreateRequest {

    @NotEmpty(message = "주문할 상품이 없습니다")
    @Valid
    private List<OrderItemRequest> items;
}
