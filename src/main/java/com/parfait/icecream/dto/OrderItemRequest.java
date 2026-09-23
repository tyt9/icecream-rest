package com.parfait.icecream.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "상품을 선택해주세요")
    private String productId;

    @NotNull(message = "토핑 목록이 없습니다")
    private List<String> toppingIds;
}
