package com.test.pojo;

import java.util.List;

//类别
public class Category {

    private int cid;

    private String ctitle;

    private int parentId;

    //子类别
    private List<Category> subCategoryList;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", ctitle='" + ctitle + '\'' +
                ", parentId=" + parentId +
                ", subCategoryList=" + subCategoryList +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
