package com.test.mapper;

import com.test.pojo.CartInfo;

public interface CartInfoMapper {

    public int selectCartInfoExists(CartInfo cartInfo);

    public int updateCartInfo(CartInfo cartInfo);

    public int addCartInfo(CartInfo cartInfo);

    public int deleteGoodsFromCart(CartInfo cartInfo);
}
