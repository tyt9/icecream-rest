package com.parfait.icecream.controller;

import com.parfait.icecream.dto.Order;
import com.parfait.icecream.dto.OrderItemRequest;
import com.parfait.icecream.dto.OrderPage;
import com.parfait.icecream.dto.OrderResult;
import com.parfait.icecream.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Integer> createOrder(@RequestBody List<OrderItemRequest> items) {
        int orderId = orderService.placeOrder(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }

    @GetMapping("/orders")
    public OrderPage getOrders(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size) {
        return orderService.selectOrders(page, size);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderResult> getOrder(@PathVariable int orderId) {
        OrderResult result = orderService.getOrder(orderId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable int orderId) {
        if (!orderService.cancelOrder(orderId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
