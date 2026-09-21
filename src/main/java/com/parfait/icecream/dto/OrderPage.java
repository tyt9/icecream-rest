package com.parfait.icecream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderPage {
    private List<Order> orders;
    private int page;
    private int totalPages;
}