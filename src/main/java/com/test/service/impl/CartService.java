package com.test.service.impl;

import com.test.mapper.CartInfoMapper;
import com.test.mapper.CartMapper;
import com.test.mapper.GoodsSkuMapper;
import com.test.pojo.Cart;
import com.test.pojo.CartInfo;
import com.test.pojo.GoodsSku;
import com.test.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartInfoMapper cartInfoMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    public GoodsSkuMapper getGoodsSkuMapper() {
        return goodsSkuMapper;
    }

    public void setGoodsSkuMapper(GoodsSkuMapper goodsSkuMapper) {
        this.goodsSkuMapper = goodsSkuMapper;
    }

    public CartMapper getCartMapper() {
        return cartMapper;
    }

    public void setCartMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public CartInfoMapper getCartInfoMapper() {
        return cartInfoMapper;
    }

    public void setCartInfoMapper(CartInfoMapper cartInfoMapper) {
        this.cartInfoMapper = cartInfoMapper;
    }


    //添加商品到购物车
    @Override
    public int addGoodsToCart(CartInfo cartInfo) {

        //判断商品是否已在购物车种
        int count = cartInfoMapper.selectCartInfoExists(cartInfo);
        //如果存在 则直接更新数量就可以
        if(count>0){
            cartInfoMapper.updateCartInfo(cartInfo);
        }
        //如果不存在 则需要添加商品到购物车中
        else {
            cartInfoMapper.addCartInfo(cartInfo);
            //更新购物车的总数量（添加进来的商品的种类）
            cartMapper.updateCart(cartInfo.getCartId());
        }

        //返回当前购物车的总数量
        return cartMapper.selectCartTotalNum(cartInfo.getCartId());

    }

    @Override
    public Cart selectCartList(int cartId) {
        //1.根据购物车id查询该购物车中的所有sku商品属性信息 sku_properties
        List<GoodsSku> goodsSkuList= goodsSkuMapper.selectGoodsSkuByCartId(cartId);

        //2.将sku_properties修改为
        for(int i=0;i<goodsSkuList.size();i++){
            GoodsSku goodsSku = goodsSkuList.get(i);
            String skuProperties = goodsSku.getSkuProperties();
            skuProperties=skuProperties.replaceAll(",","','");
            skuProperties="'"+skuProperties+"'";
            goodsSku.setSkuProperties(skuProperties);
        }
        //3.将cartId和sku商品的属性信息(goodsSkuList)传到mapper查询
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cartId",cartId);
        map.put("list",goodsSkuList);
        Cart cart=cartMapper.selectCartList(map);

        return cart;
    }

    //从购物车中删除商品
    @Override
    public int deleteGoodsFromCart(CartInfo cartInfo) {

        //1 先删除
        cartInfoMapper.deleteGoodsFromCart(cartInfo);
        //2 更新购物车中的总数
        cartMapper.updateCart2(cartInfo.getCartId());
        //3 返回商品总数
        return cartMapper.selectCartTotalNum(cartInfo.getCartId());



    }


}
