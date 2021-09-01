package com.test.pojo;

//属性值对象
public class AttributeValue {

    private int attrValueId;

    private String attrValue;

    @Override
    public String toString() {
        return "AttributeValue{" +
                "attrValueId=" + attrValueId +
                ", attrValue='" + attrValue + '\'' +
                '}';
    }

    public int getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(int attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }
}
