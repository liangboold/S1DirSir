package com.bw.database.user;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 * @ClassName GoodsBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/23 15:31
 * @Version 1.0
 */
@Entity
public class GoodsBean {
    @Id
    private Long id;
    private int categoryId;
    private String goodsDesc;
    private String goodsDefaultIcon;
    private String goodsDefaultPrice;
    private String goodsDefaultSku;
    private int goodsCount;
    private Boolean ischeck;
    @Generated(hash = 1622803246)
    public GoodsBean(Long id, int categoryId, String goodsDesc,
            String goodsDefaultIcon, String goodsDefaultPrice,
            String goodsDefaultSku, int goodsCount, Boolean ischeck) {
        this.id = id;
        this.categoryId = categoryId;
        this.goodsDesc = goodsDesc;
        this.goodsDefaultIcon = goodsDefaultIcon;
        this.goodsDefaultPrice = goodsDefaultPrice;
        this.goodsDefaultSku = goodsDefaultSku;
        this.goodsCount = goodsCount;
        this.ischeck = ischeck;
    }
    @Generated(hash = 1806305570)
    public GoodsBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getGoodsDesc() {
        return this.goodsDesc;
    }
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public String getGoodsDefaultIcon() {
        return this.goodsDefaultIcon;
    }
    public void setGoodsDefaultIcon(String goodsDefaultIcon) {
        this.goodsDefaultIcon = goodsDefaultIcon;
    }
    public String getGoodsDefaultPrice() {
        return this.goodsDefaultPrice;
    }
    public void setGoodsDefaultPrice(String goodsDefaultPrice) {
        this.goodsDefaultPrice = goodsDefaultPrice;
    }
    public String getGoodsDefaultSku() {
        return this.goodsDefaultSku;
    }
    public void setGoodsDefaultSku(String goodsDefaultSku) {
        this.goodsDefaultSku = goodsDefaultSku;
    }
    public int getGoodsCount() {
        return this.goodsCount;
    }
    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
    public Boolean getIscheck() {
        return this.ischeck;
    }
    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }
}
