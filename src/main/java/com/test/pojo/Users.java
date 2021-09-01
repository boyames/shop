package com.test.pojo;
//用户
public class Users {

    private int userId;
    private String uname;
    private String upwd;
    //包含购物车
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", cart=" + cart +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
