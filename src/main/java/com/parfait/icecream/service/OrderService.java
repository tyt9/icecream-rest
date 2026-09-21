package com.parfait.icecream.service;

import com.parfait.icecream.dao.OrderDAO;
import com.parfait.icecream.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    @Transactional
    public int placeOrder(List<OrderItemRequest> items){
        int total = 0;
        for (OrderItemRequest item : items) {
            if (orderDAO.decreaseProductStock(item.getProductId()) == 0) {
                throw new IllegalStateException("품절된 상품입니다: " + item.getProductId());
            }
            total += orderDAO.selectProductPrice(item.getProductId());
            for (String toppingId : item.getToppingIds()) {
                if (orderDAO.decreaseToppingStock(toppingId) == 0) {
                    throw new IllegalStateException("품절된 상품입니다: " + toppingId);
                }
                total += orderDAO.selectToppingPrice(toppingId);
            }
        }
        Order order = new Order();
        order.setTotalAmount(total);
        orderDAO.insertOrder(order);
        int orderId = order.getOrderId();
        for (OrderItemRequest item : items) {
            OrderDetail orderDetail = OrderDetail.builder().orderId(orderId).productId(item.getProductId()).build();
            orderDAO.insertOrderDetail(orderDetail);
            int orderDetailId = orderDetail.getDetailId();
            for (String toppingId : item.getToppingIds()) {
                orderDAO.insertToppingDetail(orderDetailId, toppingId);
            }
        }
        return orderId;
    }

    public OrderPage selectOrders(int page, int size) {
        if (page < 1) page = 1;
        int offset = (page - 1) * size;
        List<Order> orders = orderDAO.selectOrders(offset, size);

        int total = orderDAO.countOrders();
        int totalPages = (total + size - 1) / size;

        return new OrderPage(orders, page, totalPages);
    }

    public  OrderResult getOrder(int orderId){
        return orderDAO.selectOrder(orderId);
    }

    public boolean cancelOrder(int orderId) {
        return orderDAO.cancelOrder(orderId) > 0;
    }
}
