package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.ClubPostDAO;
import com.example.club.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService implements IPostService {
    @Autowired
    private ClubPostDAO clubpostdao;

//    private Random r=new Random();
    @Override
    public JSONObject createPost(JSONObject inform, int UserId){

        JSONObject newpost = new JSONObject();
        newpost.put("title", inform.getString("title"));
        newpost.put("context", inform.getString("context"));
        newpost.put("image", inform.getString("image"));
        newpost.put("club", inform.getIntValue("clubId"));
        newpost.put("creator", UserId);
        newpost.put("thumbs", 0);
        Date date = new Date();
        newpost.put("date", date);
        newpost.put("datemodify", date);

        int statenow = clubpostdao.createPost(newpost);
        //state = 1, success; state = 0, 和同一个club下的post重名； state = 2，创建超时
        if (statenow == 1){
            //state = 1, success。 res的state可能等于2，创建成功之后访问超时
            JSONObject res = clubpostdao.getPostbyTitleANDClub(inform.getIntValue("clubId"), inform.getString("title"));
            res.put("state", statenow);
            return res;
        }
        else{
            //state = 0, 和同一个club下的post重名； state = 2，创建超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            return res;
        }
    }

    @Override
    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId){

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
    public JSONObject viewPostInUser(int PostId, int UserId){
        JSONObject tmp = clubpostdao.getPostbyId(PostId);
        int thumbedornot = clubpostdao.thumbedOrNot(PostId, UserId);
        tmp.put("thumbed or not", thumbedornot);
        return tmp;
    }

    @Override
    public JSONObject viewPostList(){
        //state=1表示访问成功，形式是{“state”:1, "post1":JSONObject, "post2":JSONObject, ..., }
        //state=2表示访问超时
        JSONObject inform = clubpostdao.listAllPosts();
        return inform;
    }

    @Override
    public JSONObject viewPostsbyUser(int UserId){
        //state=1表示访问成功，形式是{“state”:1, "post1":JSONObject, "post2":JSONObject, ..., }
        //state=2表示访问超时
        JSONObject inform = clubpostdao.listUserPosts(UserId);
        return inform;
    }

    @Override
    public JSONObject viewPostsbyClub(int ClubId,int UserId){
        //state=1表示访问成功，形式是{“state”:1, "post1":JSONObject, "post2":JSONObject, ..., }
        //state=2表示访问超时
        JSONObject inform = clubpostdao.listClubPosts(ClubId);
        return inform;
    }

    @Override
    public JSONObject ThumbOrUnthumb(int PostId, int UserId){
        int flag = clubpostdao.changethumbpost(PostId, UserId);
        if (flag==1){
            JSONObject tmp = clubpostdao.getPostbyId(PostId);
            int thumbedornot = clubpostdao.thumbedOrNot(PostId, UserId);
            tmp.put("thumbed or not", thumbedornot);
            return tmp;
        }
        else{
            JSONObject tmp = new JSONObject();
            tmp.put("state", 2);
            return tmp;
        }
    }



}
