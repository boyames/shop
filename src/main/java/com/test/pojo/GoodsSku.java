package com.test.pojo;

//GoodsSku表映射类
public class GoodsSku {

    private int skuId;

    private int goodsId;

    private float price;

    private int num;

    private String skuName;

    private String skuProperties;

    @Override
    public String toString() {
        return "GoodsSku{" +
                "skuId=" + skuId +
                ", goodsId=" + goodsId +
                ", price=" + price +
                ", num=" + num +
                ", skuName='" + skuName + '\'' +
                ", skuProperties='" + skuProperties + '\'' +
                '}';
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuProperties() {
        return skuProperties;
    }

    public void setSkuProperties(String skuProperties) {
        this.skuProperties = skuProperties;
    }
}
