package com.test.pojo;

import java.util.List;

//创建的用来存放购物车中每个商品的详细信息
public class CartItem {

    private int skuId;
    private String goodsName;
    private String goodsImg;
    private float price;
    private int buyNum;
    private List<AttrNameValue> attrNameValueList;

    @Override
    public String toString() {
        return "CartItem{" +
                "skuId=" + skuId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", price=" + price +
                ", buyNum=" + buyNum +
                ", attrNameValueList=" + attrNameValueList +
                '}';
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public List<AttrNameValue> getAttrNameValueList() {
        return attrNameValueList;
    }

    public void setAttrNameValueList(List<AttrNameValue> attrNameValueList) {
        this.attrNameValueList = attrNameValueList;
    }
}
