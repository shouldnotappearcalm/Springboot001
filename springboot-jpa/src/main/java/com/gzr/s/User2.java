package com.gzr.s;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

/**
 * ${description}
 * Created by GZR
 * 2017-06-29
 */

@Entity
@Table(name="user")
public class User2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;
    @Column(name = "u_name")
    private String u_name;
    @Column(name="password")
    private String password;

    public User2(String u_name, String password) {
        this.u_name = u_name;
        this.password = password;
    }

    public User2() {
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
