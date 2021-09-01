package com.test.mapper;

import com.test.pojo.Order;

import java.util.List;

public interface OrdersMapper {

    public int addOrder(Order order);

    public int updateOrderState(int orderId);

    public List<Order> selectOrderList(int userId);
}
