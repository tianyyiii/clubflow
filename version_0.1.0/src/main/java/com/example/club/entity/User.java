package com.example.club.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private int id;
    private String password;
    private String name;
    private String intros;
    private Timestamp createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntros() {return intros;}

    public void setIntros(String intros) {this.intros = intros;}
}
