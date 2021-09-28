package com.bw.database.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.blankj.utilcode.util.Utils;

import java.util.List;


public class GreenDaoManager {
    private final GoodsBeanDao goodsBeanDao;

    public GreenDaoManager() {
        DaoMaster.DevOpenHelper goods = new DaoMaster.DevOpenHelper(Utils.getApp(), "goods");
        SQLiteDatabase writableDatabase = goods.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        goodsBeanDao = daoSession.getGoodsBeanDao();
    }

    private static volatile GreenDaoManager greenDaoManager;

    //双重锁实例化对象
    public static synchronized GreenDaoManager getInstance() {
        if (greenDaoManager == null){
            synchronized (GreenDaoManager.class){
                if (greenDaoManager == null){
                    greenDaoManager = new GreenDaoManager();
                }
            }
        }
        return greenDaoManager;
    }

    public GoodsBeanDao getGoodsBeanDao() {
        return goodsBeanDao;
    }

    //查询所有
    public List<GoodsBean> getGoodsList() {
        return goodsBeanDao.loadAll();
    }

    //删除
    public void goodsDel(GoodsBean goodsBean){
        goodsBeanDao.delete(goodsBean);
    }

    //修改
    public void goodsUpdata(GoodsBean goodsBean){
        goodsBeanDao.update(goodsBean);
    }

}
