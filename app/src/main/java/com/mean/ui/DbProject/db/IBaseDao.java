package com.mean.ui.DbProject.db;

/**
 * Created by renzhenhua on 2018/3/9.
 */

public interface IBaseDao <T>{
    long insert(T entity);
//    long update(T entity,T where);
//    long delete(T where);
}