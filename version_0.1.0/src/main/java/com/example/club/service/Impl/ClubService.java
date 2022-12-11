package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.DAO.AccountDAO;
import com.example.club.DAO.ClubDAO;
import com.example.club.DAO.ClubPostDAO;
import com.example.club.entity.Club;
import com.example.club.service.IClubService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class ClubService implements IClubService {

    @Autowired
    private ClubDAO clbdao;

    @Override
    public JSONObject createClub(JSONObject inform, int UserId){
        return clbdao.createclub(inform, UserId);
    }

    @Override
    public JSONObject modifyClub(JSONObject inform,int ClubId,int UserId){
        return clbdao.modifyclub(inform, ClubId, UserId);
    }

    @Override
    public JSONObject viewClub(int ClubId,int UserId){
        return clbdao.view(ClubId, UserId);
    }

    @Override
    public JSONObject viewClubbyAccount(int UserId){
        return clbdao.viewbyaccount(UserId);
    }

    @Override
    public JSONObject viewAnnouncement(int UserId){
        return clbdao.viewannouncement(UserId);
    }

    @Override
    public JSONObject viewAttensionList(int UserId){
        return clbdao.viewattensionlist(UserId);
    }
}
