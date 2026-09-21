package com.parfait.icecream.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderResultTopping {
    private int toppingDetailId;
    private String toppingName;
}
