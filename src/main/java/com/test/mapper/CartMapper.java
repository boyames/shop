package com.test.mapper;

import com.test.pojo.Cart;

import java.util.Map;

public interface CartMapper {

    public int addCart(Cart cart);

    public int updateCart(int cartId);

    public int updateCart2(int cartId);

    public int selectCartTotalNum(int cartId);

    public Cart selectCartList(Map<String,Object> map);
}
