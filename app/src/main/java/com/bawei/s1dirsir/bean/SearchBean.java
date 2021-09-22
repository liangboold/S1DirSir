package com.bawei.s1dirsir.bean;

/**
 * @package:com.bawei.s1dirsir.bean
 * @fileName:SearchBean
 * @date on:2021/9/22 16:10
 * @another:HG
 * @email:1572651596@qq.com
 */
public class SearchBean {
    String msg;

    public SearchBean() {
    }

    public SearchBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SearchBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
