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
public class PostService implements IPostService{
    @Autowired
    private ClubPostDAO clubpostdao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ClubDAO clubDAO;

//    private Random r=new Random();
    @Override
    public JSONObject createPost(JSONObject inform, int UserId){

        JSONObject newpost = new JSONObject();
        newpost.put("title", inform.getString("title"));
        newpost.put("context", inform.getString("context"));
        newpost.put("image", inform.getString("image"));
        newpost.put("club", inform.getString("club name"));
        newpost.put("name", userDao.getusername(UserId));
        newpost.put("thumbs",0);
        Date date = new Date();
        newpost.put("date",date.toString());
        newpost.put("datemodify",date.toString());

        int statenow = clubpostdao.createPost(newpost);
        //state = 1, success; state = 0, 和同一个club下的post重名； state = 2，创建超时
        if (statenow == 1){
            //state = 1, success。 res的state可能等于2，创建成功之后访问超时
            JSONObject res = clubpostdao.getPostbyNameANDCreator(inform.getString("club name"), inform.getString("title"));
            return res;
        }
        else{
            //state = 0, 和同一个club下的post重名； state = 2，创建超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            res.put("PostId", newpost.getInteger("id"));
            return res;
        }
    }

    @Override
    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId){
/*        目前还是静态，因为前端没有这一部分页面*/
 /*       return clubpostdao.modifyPost(inform, UserId);*/
        int statenow = clubpostdao.modifypost(inform, PostId, UserId);
        //state = 1, 成功修改post；state = 0, 不合规范，修改失败；state = 2, 修改超时
        if (statenow == 1){
            //修改成功也可能访问超时
            JSONObject res = clubpostdao.getPostbyId(PostId);
            return res;
        }
        else{
            //state = 0, 不合规范，修改失败；state = 2, 修改超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            res.put("PostId", PostId);
            return res;
        }
    }

    @Override
    public JSONObject viewPost(int PostId){
        return clubpostdao.getPostbyId(PostId);
    }

    @Override
    public JSONObject viewPostsbyUser(int UserId){
        List<Map<String,Object>> inform = clubpostdao.listUserPosts(UserId);
        JSONObject res = new JSONObject();
        for (int i=0; i<inform.size(); i++){
            JSONObject post = new JSONObject(inform.get(i));
            JSONObject tmp = new JSONObject();
            tmp.put("title", post.getString("title"));
            tmp.put("context", post.getString("context"));
            tmp.put("thumbs-up num",0);
            tmp.put("comments num",0);
            tmp.put("club name", clubDAO.getClubbyId(post.getIntValue("club")).getString("clubName"));
            tmp.put("club profile",clubDAO.getClubbyId(post.getIntValue("club")).getString("image"));
            tmp.put("image", post.getString("image"));
            tmp.put("club id", post.getIntValue("club"));

            res.put("user"+Integer.toString(i),tmp);
        }
        return res;
    }

    @Override
    public JSONObject viewPostbyClub(int ClubId,int UserId){
        List<Map<String,Object>> inform = clubpostdao.listClubPosts(ClubId);
        JSONObject res = new JSONObject();
        for (int i=0;i<inform.size();i++){
            JSONObject post = new JSONObject(inform.get(i));
            JSONObject tmp = new JSONObject();
            tmp.put("title", post.getString("title"));
            tmp.put("context", post.getString("context"));
            tmp.put("thumbs-up num",0);
            tmp.put("comments num",0);
            tmp.put("club name", clubDAO.getClubbyId(post.getIntValue("club")).getString("clubName"));
            tmp.put("club profile",clubDAO.getClubbyId(post.getIntValue("club")).getString("image"));
            tmp.put("image", post.getString("image"));
            tmp.put("club id", post.getIntValue("club"));

            res.put("user"+Integer.toString(i),tmp);
        }
        return res;

    }




}
