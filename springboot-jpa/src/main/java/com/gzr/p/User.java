package com.gzr.p;

import javax.persistence.*;

/**
 * ${description}
 * Created by GZR
 * 2017-06-29
 */
@Entity
@Table(name = "testuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "pwd")
    private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
