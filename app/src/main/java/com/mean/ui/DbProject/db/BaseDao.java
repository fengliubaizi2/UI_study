package com.mean.ui.DbProject.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;


import com.mean.ui.DbProject.annotation.DbField;
import com.mean.ui.DbProject.annotation.DbTable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by renzhenhua on 2018/3/10.
 */

public class BaseDao<T> implements IBaseDao<T> {
    //数据库引用
    private SQLiteDatabase sqLiteDatabase;
    //表名
    private String tableName;
    //持有操作数据库所对应的java类型
    private Class<T> entityClass;
    //标识：用来表示是否做过初始化操作
    private boolean isInit = false;
    //定义一个缓存空间(key-字段名    value-成员变量)
    private HashMap<String, Field> cacheMap;

    protected boolean init(SQLiteDatabase sqLiteDatabase, Class<T> entityClass) {
        this.sqLiteDatabase = sqLiteDatabase;
        this.entityClass = entityClass;
        if (!isInit){
            if (entityClass.getAnnotation(DbTable.class)==null){
                tableName=entityClass.getSimpleName();
            }else {
                tableName=entityClass.getAnnotation(DbTable.class).value();
            }
            if (!sqLiteDatabase.isOpen()){
                return false;
            }
//          建表
            //create table if not exists tb_user(_id integer,name varchar(20),password varchar(20))
            //单独用个方法来生成create命令

            String createTableSql=getCreateTableSql();
            sqLiteDatabase.execSQL(createTableSql);
//            cacheMap=new HashMap<>();
//            initCacheMap();
            isInit=true;

        }
        return isInit;
    }

    private  String getCreateTableSql(){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("create table if not exists ");
        stringBuffer.append(tableName);
        stringBuffer.append("(");
        Field[] fields=entityClass.getDeclaredFields();
        for(Field field:fields){
            Class type=field.getType();
            if (field.getAnnotation(DbField.class)!=null){
                if(type==String.class){
                    stringBuffer.append(field.getAnnotation(DbField.class).value()+" TEXT,");
                }else if(type==Integer.class){
                    stringBuffer.append(field.getAnnotation(DbField.class).value()+" INTEGER,");
                }else if(type==Long.class){
                    stringBuffer.append(field.getAnnotation(DbField.class).value()+" BIGINT,");
                }else if(type==Double.class){
                    stringBuffer.append(field.getAnnotation(DbField.class).value()+" DOUBLE,");
                }else if(type==byte[].class){
                    stringBuffer.append(field.getAnnotation(DbField.class).value()+" BLOB,");
                }else{
                    //不支持的类型号
                    continue;
                }
            }else {
                if(type==String.class){
                    stringBuffer.append(field.getName()+" TEXT,");
                }else if(type==Integer.class){
                    stringBuffer.append(field.getName()+" INTEGER,");
                }else if(type==Long.class){
                    stringBuffer.append(field.getName()+" BIGINT,");
                }else if(type==Double.class){
                    stringBuffer.append(field.getName()+" DOUBLE,");
                }else if(type==byte[].class){
                    stringBuffer.append(field.getName()+" BLOB,");
                }else{
                    //不支持的类型号
                    continue;
                }
            }

        }
        if (stringBuffer.charAt(stringBuffer.length()-1)==','){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
    @Override
    public long insert(T entity) {

        return 0;
    }

}
