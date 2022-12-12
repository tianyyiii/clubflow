package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.ClubDAO;
import com.example.club.dao.ClubPostDAO;
import com.example.club.dao.UserDao;
import com.example.club.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class PostService {
    @Autowired
    private ClubPostDAO clubpostdao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ClubDAO clubDAO;

    private Random r=new Random();

    public JSONObject createPost(JSONObject inform, int UserId){
        JSONObject res=new JSONObject();
        res.put("title",inform.getString("title"));
        res.put("context",inform.getString("context"));
        res.put("image",inform.getString("image"));
        res.put("club",inform.getString("club name"));
        res.put("id",r.nextInt(1000));
        res.put("name",userDao.username(UserId));
        res.put("thumbs",0);
        Date date=new Date();
        res.put("date",date.toString());
        res.put("datemodify",date.toString());
        Integer state=clubpostdao.createPost(res);
        JSONObject res1=new JSONObject();
        res1.put("state",state);
        res1.put("PostId",res.getInteger("id"));
        return res1;
    }


    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId){
/*        目前还是静态，因为前端没有这一部分页面*/
 /*       return clubpostdao.modifyPost(inform, UserId);*/
        JSONObject state=new JSONObject();
        inform.put("state",1);
        return inform;
    }


    public JSONObject viewPost(int PostId, int UserId){
        return clubpostdao.viewPost(PostId);
    }


    public JSONObject viewPostbyUser(int UserId){
        List<Map<String,Object>> inform=clubpostdao.viewPostbyUser(UserId);
        JSONObject res=new JSONObject();
        for (int i=0;i<inform.size();i++){
            JSONObject temp=new JSONObject(inform.get(i));
            JSONObject temp1=new JSONObject();
            temp1.put("title",temp.getString("title"));
            temp1.put("context",temp.getString("context"));
            temp1.put("thumbs-up num",0);
            temp1.put("comments num",0);
            temp1.put("club name", clubDAO.view(temp.getInteger("club")).getString("clubName"));
            temp1.put("club profile",clubDAO.view(temp.getInteger("club")).getString("image"));
            temp1.put("image",temp.getString("image"));
            temp1.put("club id",temp.getInteger("club"));

            res.put("user"+Integer.toString(i),temp1);
        }
        return res;



    }


    public JSONObject viewPostbyClub(int ClubId,int UserId){
        List<Map<String,Object>> inform=clubpostdao.viewPostbyUser(ClubId);
        JSONObject res=new JSONObject();
        for (int i=0;i<inform.size();i++){
            JSONObject temp=new JSONObject(inform.get(i));
            JSONObject temp1=new JSONObject();
            temp1.put("title",temp.getString("title"));
            temp1.put("context",temp.getString("context"));
            temp1.put("thumbs-up num",0);
            temp1.put("comments num",0);
            temp1.put("club name", clubDAO.view(temp.getInteger("club")).getString("clubName"));
            temp1.put("club profile",clubDAO.view(temp.getInteger("club")).getString("image"));
            temp1.put("image",temp.getString("image"));
            temp1.put("club id",temp.getInteger("club"));

            res.put("club"+Integer.toString(i),temp1);
        }
        return res;



    }




}
