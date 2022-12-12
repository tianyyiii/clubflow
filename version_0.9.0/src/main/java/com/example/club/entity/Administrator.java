package com.example.club.entity;

import com.example.club.DAO.AccountDAO;
import com.example.club.dao.ClubDAO;
import com.example.club.DAO.HabbitDAO;
import com.example.club.dao.ClubPostDAO;
import com.example.club.DAO.HabbitPostDAO;

public class Administrator {
    private int id;
    private String name;
    private String password;

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


//    private boolean deleteClub(int clubId){
//
//    }
//    private boolean deleteHabbit(int habbitId){
//
//    }
//    private boolean deleteUser(int userId){
//
//    }
//    private boolean deleteClubPost(int postId){
//
//    }
//    private boolean deleteHabbitPost(int postId){
//
//    }

}
