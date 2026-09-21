package com.parfait.icecream.dao;

import com.parfait.icecream.dto.Order;
import com.parfait.icecream.dto.OrderDetail;
import com.parfait.icecream.dto.OrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDAO {
    int selectProductPrice(String productId);
    int selectToppingPrice(String toppingId);
    void insertOrder(Order order);
    void insertOrderDetail(OrderDetail orderDetail);
    void insertToppingDetail(@Param("orderDetailId") int orderDetailId,
                             @Param("toppingId") String toppingId);
    int decreaseProductStock(String productId);
    int decreaseToppingStock(String toppingId);
    List<Order> selectOrders(@Param("offset") int offset, @Param("size") int size);
    OrderResult selectOrder(int orderId);
    int cancelOrder(int orderId);
    int countOrders();
}
