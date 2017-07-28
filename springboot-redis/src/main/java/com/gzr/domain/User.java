package com.gzr.domain;

import java.io.Serializable;

/**
 * ${description}
 * Created by GZR
 * 2017-06-30
 */

public class User implements Serializable{

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
