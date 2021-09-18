package com.bawei.s1dirsir.bean;

/**
 * @package:com.bawei.s1dirsir.bean
 * @fileName:DiscountBean
 * @date on:2021/9/17 18:44
 * @another:HG
 * @email:1572651596@qq.com
 */
public class DiscountBean {
    private String url;

    public DiscountBean() {
    }

    public DiscountBean(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DiscountBean{" +
                "url='" + url + '\'' +
                '}';
    }
}
