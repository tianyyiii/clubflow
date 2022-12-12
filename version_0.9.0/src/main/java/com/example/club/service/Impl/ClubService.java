package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.DAO.AccountDAO;
import com.example.club.dao.ClubDAO;
import com.example.club.dao.ClubPostDAO;
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
import java.util.List;
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
      /*  需要增加鉴权，目前可以先不实现*/
        JSONObject inform1=new JSONObject();
        inform1.put("id",r.nextInt(1000));
        Date date=new Date();
        inform1.put("date",date.toString());
        Integer state=clbdao.createclub(inform);
        String user=userDao.viewuser(UserId);
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
   /*     需要增加鉴权，目前先不实现*/
        JSONObject res=new JSONObject();
        Integer state= clbdao.modifyclub(inform, ClubId);
        res.put("state",state);
        return res;

    }

    @Override
    public JSONObject viewClub(int ClubId,int UserId){
        JSONObject res=new JSONObject();
        JSONObject res1=clbdao.view(ClubId);
        res.put("name",res.getString("clubName"));
        res.put("category","艺术类");
        res.put("fans number",100);
        res.put("publications number",100);
        res.put("comments number",50);
        res.put("inform",res1.getString("clubInfo"));
        res.put("profile",res1.getString("image"));
        res.put("created time",res1.getString("createDate"));
        res.put("subscribe",156);
        res.put("res1",res1);


        return res;
    }

    @Override
    public JSONObject viewClubbyAccount(int UserId){
        List<Object> list=clbdao.viewbyAccount(UserId);
        JSONObject res=new JSONObject();
        for (int i=0;i<list.size();i++){
            JSONObject temp=clbdao.view((Integer) list.get(i));
            res.put("club"+Integer.toString(i),temp);
        }
        return res;

    }
    @Override
    public JSONObject viewAnnouncement(int UserId){
        /*return clbdao.viewannouncement(UserId);*/
/*        因为数据库目前没有announcement存储，同时前端没有发布的位置，所以暂时静态*/
        JSONObject AnnouncementList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject Announcement=new JSONObject();
            Announcement.put("context","塔可夫斯基《乡愁》放映");
            AnnouncementList.put("announcement"+Integer.toString(i),Announcement);
        }
        return AnnouncementList;
    }


    @Override
    public JSONObject viewAttensionList(int UserId){
/*        目前前端没有做界面，所以可以先不实现*/
/*        return clbdao.viewattensionlist(UserId);*/
        JSONObject res=new JSONObject();
        return res;
    }
}
