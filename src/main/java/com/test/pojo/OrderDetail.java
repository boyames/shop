package com.test.pojo;



import java.util.List;

//订单详情表
public class OrderDetail {

    private  int detailsId;

    private int orderId;

    private int skuId;

    private float buyPrice;

    private int num;

    //在查看订单详情时 商品属性信息
    private String goodsName;

    private String goodsImg;

    private List<AttrNameValue> attrNameValueList;

    public List<AttrNameValue> getAttrNameValueList() {
        return attrNameValueList;
    }

    public void setAttrNameValueList(List<AttrNameValue> attrNameValueList) {
        this.attrNameValueList = attrNameValueList;
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



    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
