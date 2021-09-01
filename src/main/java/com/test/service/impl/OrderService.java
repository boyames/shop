package com.test.service.impl;

import com.test.mapper.CartInfoMapper;
import com.test.mapper.CartMapper;
import com.test.mapper.OrderDetailMapper;
import com.test.mapper.OrdersMapper;
import com.test.pojo.CartInfo;
import com.test.pojo.Order;
import com.test.pojo.OrderDetail;
import com.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrdersMapper ordersMapper;

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public OrderDetailMapper getOrderDetailMapper() {
        return orderDetailMapper;
    }

    public void setOrderDetailMapper(OrderDetailMapper orderDetailMapper) {
        this.orderDetailMapper = orderDetailMapper;
    }
    @Autowired
    private CartInfoMapper cartInfoMapper;


    public CartInfoMapper getCartInfoMapper() {
        return cartInfoMapper;
    }

    public void setCartInfoMapper(CartInfoMapper cartInfoMapper) {
        this.cartInfoMapper = cartInfoMapper;
    }

    @Autowired
    public CartMapper cartMapper;

    public CartMapper getCartMapper() {
        return cartMapper;
    }

    public void setCartMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public int addOrder(Order order) {

        //1.添加订单基本信息到orders表，返回订单id
        ordersMapper.addOrder(order); //返回的订单编号 会存入order对象的orderId属性中
        //2.添加订单详情到order_detail表

        // int i=3/0;

        //2.1查询订单详情中的商品信息
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userId",order.getUserId());
        map.put("list",order.getOrderDetailList());
        List<OrderDetail> orderDetailList= orderDetailMapper.selectOrderDetailList(map);
        //2.2添加订单详情到order_detail表
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("orderId",order.getOrderId());
        map2.put("list",orderDetailList);
        orderDetailMapper.addOrderDetailList(map2);
        return order.getOrderId();
    }

    @Override
    public int addOrder(Order order,int cartId) {

        //1.添加订单基本信息到orders表，返回订单id
        ordersMapper.addOrder(order); //返回的订单编号 会存入order对象的orderId属性中
        //2.添加订单详情到order_detail表


        //2.1查询订单详情中的商品信息
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userId",order.getUserId());
        map.put("list",order.getOrderDetailList());
        List<OrderDetail> orderDetailList= orderDetailMapper.selectOrderDetailList(map);
        //2.2添加订单详情到order_detail表
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("orderId",order.getOrderId());
        map2.put("list",orderDetailList);
        orderDetailMapper.addOrderDetailList(map2);

        //3.删除购物车中对应的商品
        for(OrderDetail orderDetail:order.getOrderDetailList())
        {
            CartInfo cartInfo=new CartInfo();
            cartInfo.setCartId(cartId);
            cartInfo.setSkuId(orderDetail.getSkuId());

            cartInfoMapper.deleteGoodsFromCart(cartInfo);
            cartMapper.updateCart2(cartId);
        }
        return order.getOrderId();
    }

    //修改订单状态 为已付款
    @Override
    public int updateOrderState(int orderId) {
        return ordersMapper.updateOrderState(orderId);
    }

    //查询指定用户的所有订单信息
    @Override
    public List<Order> selectOrderList(int userId) {
        return ordersMapper.selectOrderList(userId);
    }
}
