package com.mean.ui.DbProject.bean;

import com.mean.ui.DbProject.annotation.DbField;
import com.mean.ui.DbProject.annotation.DbTable;

/**
 * Created by renzhenhua on 2018/3/9.
 */
@DbTable("tb_user")
public class User {
    @DbField("_id")
    private Integer id;
    private String nickname;
    private String password;

    public User(Integer id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }
}