package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.DAO.AccountDAO;
import com.example.club.DAO.ClubDAO;
import com.example.club.DAO.ClubPostDAO;
import com.example.club.dao.ClubDAO;
import com.example.club.dao.UserDao;
import com.example.club.entity.Club;
import com.example.club.service.IClubService;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class ClubService implements IClubService {

    @Autowired
    private ClubDAO clbdao;
    @Autowired
    private UserDao userDao;
    Random r=new Random();

    @Override
    public JSONObject createClub(JSONObject inform, int UserId){
        JSONObject inform1=new JSONObject();
        inform1.put("id",r.nextInt(1000));
        Date date=new Date();
        inform1.put("date",date.toString());
        Integer state=clbdao.createclub(inform);
        String user=UserDao.viewuser(UserId);
        inform1.put("creator",user);
        inform1.put("state",1);
        inform1.put("image",inform.getString("profile"));
        inform1.put("info",inform.getString("inform"));
        inform1.put("name",inform.getString("name"));
        int statenow=clbdao.createclub(inform1);
        JSONObject res=new JSONObject();
        res.put("state",statenow);
        res.put("club id",inform1.getInteger("id"));
        return res;




    }

    @Override
    public JSONObject modifyClub(JSONObject inform,int ClubId,int UserId){

        return clbdao.modifyclub(inform, ClubId);
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
