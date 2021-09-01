package com.test.service;

import com.test.pojo.Order;

import java.util.List;

public interface IOrderService {

    public int addOrder(Order order);

    public int addOrder(Order order,int cartId);

    public int updateOrderState(int orderId);

    public List<Order> selectOrderList(int userId);
}
