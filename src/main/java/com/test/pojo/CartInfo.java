package com.test.pojo;

import java.util.Date;

public class CartInfo {
    private int id;
    private int cartId;
    private int skuId;
    private int buyNum;
    private Date date;

    @Override
    public String toString() {
        return "CartInfo{" +
                "id=" + id +
                ", cartId=" + cartId +
                ", skuId=" + skuId +
                ", buyNum=" + buyNum +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CartInfo(int cartId, int skuId, int buyNum) {
        this.cartId = cartId;
        this.skuId = skuId;
        this.buyNum = buyNum;
    }

    public CartInfo(int cartId, int skuId) {
        this.cartId = cartId;
        this.skuId = skuId;
    }

    public CartInfo() {
    }
}

