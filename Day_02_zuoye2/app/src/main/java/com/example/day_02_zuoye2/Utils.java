package com.example.day_02_zuoye2;

import com.example.day_02_zuoye2.dao.DaoMaster;
import com.example.day_02_zuoye2.dao.DaoSession;
import com.example.day_02_zuoye2.dao.DataDbDao;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static Utils utils;
    private final DataDbDao dataDbDao;
    private Utils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getBaseApp(), "dbData.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dataDbDao = daoSession.getDataDbDao();
    }

    public static Utils getUtils() {
        if (utils == null){
            synchronized (Utils.class){
                if (utils == null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }
    public void insert(ArrayList<DataDb> list){
        dataDbDao.insertOrReplaceInTx(list);
    }
    public void insert(DataDb dataDb){
        dataDbDao.insertOrReplaceInTx(dataDb);
    }
    public void delete(DataDb dataDb){
        dataDbDao.delete(dataDb);
    }
    public void update(DataDb dataDb){
        dataDbDao.update(dataDb);
    }
    public List<DataDb> query(){
        return dataDbDao.queryBuilder().list();
    }
}
