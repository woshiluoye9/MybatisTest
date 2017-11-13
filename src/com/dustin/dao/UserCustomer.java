package com.dustin.dao;

import java.util.Date;

public class UserCustomer {
    //属性名和数据库表的字段对应
    private int customer_id;
    private String customer_username;// 用户姓名
    private String customer_sex;// 性别
    private Date customer_birthday;// 生日
    private String customer_address;// 地址

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_sex() {
        return customer_sex;
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public Date getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(Date customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    @Override
    public String toString() {
        return "UserCustomer{" +
                "customer_id=" + customer_id +
                ", customer_username='" + customer_username + '\'' +
                ", customer_sex='" + customer_sex + '\'' +
                ", customer_birthday=" + customer_birthday +
                ", customer_address='" + customer_address + '\'' +
                '}';
    }
}
