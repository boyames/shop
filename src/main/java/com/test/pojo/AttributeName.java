package com.test.pojo;


import java.util.List;

//属性对象
public class AttributeName {

    //属性信息
    private int attrNameId;

    private String attrName;
    //当前属性包含的属性值
    private List<AttributeValue> attributeValueList;

    @Override
    public String toString() {
        return "AttributeName{" +
                "attrNameId=" + attrNameId +
                ", attrName='" + attrName + '\'' +
                ", attributeValueList=" + attributeValueList +
                '}';
    }

    public int getAttrNameId() {
        return attrNameId;
    }

    public void setAttrNameId(int attrNameId) {
        this.attrNameId = attrNameId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<AttributeValue> getAttributeValueList() {
        return attributeValueList;
    }

    public void setAttributeValueList(List<AttributeValue> attributeValueList) {
        this.attributeValueList = attributeValueList;
    }
}
