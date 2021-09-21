package com.bawei.s1dirsir.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * @ClassName BaseBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:42
 * @Version 1.0
 */
public class BaseBean {
    private List<Data> data = new ArrayList<>();
    private String message;
    private int status;


    public class Data {
        private String categoryIcon;
        private String categoryName;
        private int id;
        private int parentId;
    }
}
