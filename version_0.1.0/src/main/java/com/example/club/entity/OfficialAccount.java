package com.example.club.entity;

import java.sql.Timestamp;

public class OfficialAccount {
    private int id;
    private String password;
    private String name;
    private Club club;
    private Timestamp createDate;
    private Timestamp lastModify;

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

    public Club getClub(){
        return club;
    }

    public Timestamp getCreateDate() {return createDate;}
}
