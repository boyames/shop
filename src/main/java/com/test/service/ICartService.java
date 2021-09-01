package com.test.service;

import com.test.pojo.Cart;
import com.test.pojo.CartInfo;

public interface ICartService {

    public int addGoodsToCart(CartInfo cartInfo);

    public Cart selectCartList(int cartId);

    public int deleteGoodsFromCart(CartInfo cartInfo);
}
