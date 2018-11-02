package com.mean.ui.DbProject.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by renzhenhua on 2018/3/10.
 */

public class BaseDaoFactory {

    private static BaseDaoFactory ourInstance = new BaseDaoFactory();

    public static BaseDaoFactory getOurInstance() {
        return ourInstance;
    }
    private SQLiteDatabase sqLiteDatabase;
    private String databasePath;

    private BaseDaoFactory() {
        databasePath = "data/data/com.mean.ui/test.db";
        sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(databasePath, null);
    }
    public <T>BaseDao<T> getBaseDao(Class<T> classEntity){
        BaseDao baseDao=null;
        try {
            baseDao=BaseDao.class.newInstance();
            baseDao.init(sqLiteDatabase,classEntity);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return baseDao;
    }
}
