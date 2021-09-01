package com.test.controller;

import com.test.pojo.*;
import com.test.service.IAddressService;
import com.test.service.ICartService;
import com.test.service.IOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IAddressService addressService;

    public IAddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(IAddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    private ICartService cartService;

    public ICartService getCartService() {
        return cartService;
    }

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    private IOrderService orderService;

    public IOrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/submitOrder")
    public ModelAndView submitOrder(String skuIdStr, HttpServletRequest request){
        HttpSession session = request.getSession();

        if(session.getAttribute("loginUser")!=null){
            //1.查询该用户的地址信息
            Users users = (Users)session.getAttribute("loginUser");
            List<Address> addressList = addressService.selectAddress(users.getUserId());
            //2.查询准备购买的商品信息
            Cart cart = cartService.selectCartList(users.getCart().getCartId());
            //4001,4009-->[4001] [4009]
            String[] skuIdArr =  skuIdStr.split(",");

            //存放所有选中的商品的信息
            List<CartItem> selectCartItemList=new ArrayList<CartItem>();

            float totalPrice=0;

            for(CartItem cartItem:cart.getCartItemList()){
                if(Arrays.asList(skuIdArr).contains(cartItem.getSkuId()+"")){
                    selectCartItemList.add(cartItem);

                    totalPrice+=cartItem.getPrice()*cartItem.getBuyNum();
                }
            }
            //3.传递到视图页展示
            ModelAndView modelAndView=new ModelAndView();

            modelAndView.addObject("addressList",addressList);
            modelAndView.addObject("selectCartItemList",selectCartItemList);
            modelAndView.addObject("totalPrice",totalPrice);
            modelAndView.setViewName("pay");
            return modelAndView;

        }
        else {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;

        }

    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public  int addOrder(int addressId,String skuIdStr,float orderAmount,HttpServletRequest request){

        HttpSession session=request.getSession();
        if(session.getAttribute("loginUser")!=null){
            Users user=(Users)session.getAttribute("loginUser");
            //1.将接收到的信息组装为order对象
            Order order=new Order();
            order.setAddressId(addressId);
            order.setUserId(user.getUserId());
            order.setOrderAmount(orderAmount);

            List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

            String[] skuIdArr=skuIdStr.split(",");
            for (String skuId : skuIdArr){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setSkuId(Integer.parseInt(skuId));//Integer.parseInt()：转换为int类型
                orderDetailList.add(orderDetail);
            }
            order.setOrderDetailList(orderDetailList);
            //2.添加到数据库
            int orderId=orderService.addOrder(order,user.getCart().getCartId());

            //更新session中的信息
            user.getCart().setTotalNum(user.getCart().getTotalNum()-skuIdArr.length);
            session.setAttribute("loginUser",user);
            //3.将订单id返回到客户端
            return orderId;
        }
        else
            return -1;

    }

    //进入订单管理页面(显示所有的订单信息)
    @RequestMapping("/orderList")
    public ModelAndView orderList(HttpServletRequest request){


        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser")!=null){
            //查询所有用户的当前订单信息
            Users user=(Users)session.getAttribute("loginUser");
            List<Order> orderList=orderService.selectOrderList(user.getUserId());
            //传递到视图页显示
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("person/order");
            modelAndView.addObject("orderList",orderList);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");

            return modelAndView;

        }

    }
}
