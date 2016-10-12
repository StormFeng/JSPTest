package com.entity;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class UserBean {

    private String user_id;
    private String phone;
    private String sex;
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {

        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "user_id='" + user_id + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
