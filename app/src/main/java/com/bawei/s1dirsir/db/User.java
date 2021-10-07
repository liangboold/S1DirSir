package com.bawei.s1dirsir.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import dagger.Module;
import org.greenrobot.greendao.annotation.Generated;

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName User
 * @Description TODO
 * @Author 海
 * @Date 2021/10/7 9:02
 * @Version 1.0
 */
@Entity
public class User {
    @Id(autoincrement = true)
    Long id;
    String Pic;
    String Title;
    String Str;
    String Price;
    @Generated(hash = 460678493)
    public User(Long id, String Pic, String Title, String Str, String Price) {
        this.id = id;
        this.Pic = Pic;
        this.Title = Title;
        this.Str = Str;
        this.Price = Price;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPic() {
        return this.Pic;
    }
    public void setPic(String Pic) {
        this.Pic = Pic;
    }
    public String getTitle() {
        return this.Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getStr() {
        return this.Str;
    }
    public void setStr(String Str) {
        this.Str = Str;
    }
    public String getPrice() {
        return this.Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }
} 