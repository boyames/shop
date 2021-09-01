package com.test.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.List;

//商品对象
public class Goods implements Serializable {

    //商品的基本信息
    @Field("id")
    private String goodsId;
    @Field
    private String goodsName;
    @Field
    private String goodsImg;
    @Field
    private float salesPrice;

    private List<AttributeName> attributeNameList;
    //商品中包含的属性信息
    public List<AttributeName> getAttributeNameList() {
        return attributeNameList;
    }

    public void setAttributeNameList(List<AttributeName> attributeNameList) {
        this.attributeNameList = attributeNameList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", salesPrice=" + salesPrice +
                ", attributeNameList=" + attributeNameList +
                '}';
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }
}
