package com.entity;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class BaseBean<T> {
    private String ret;
    private String ret_info;
    private String ret_code;
    private T t;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getRet_info() {
        return ret_info;
    }

    public void setRet_info(String ret_info) {
        this.ret_info = ret_info;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
