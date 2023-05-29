package com.src.model;

import java.io.Serializable;

/**
 * 功能
 *
 * @author caojianbang
 * @date 20/12/2021 12:47
 */
public class User implements Serializable {

    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
