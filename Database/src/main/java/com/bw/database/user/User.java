package com.bw.database.user;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @package:com.bw.database.user
 * @fileName:User
 * @date on:2021/9/11 8:19
 * @another:HG
 * @email:1572651596@qq.com
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String msg;
    @Generated(hash = 278507346)
    public User(Long id, String name, String msg) {
        this.id = id;
        this.name = name;
        this.msg = msg;
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
