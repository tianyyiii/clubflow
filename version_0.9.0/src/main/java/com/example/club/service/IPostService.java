package com.example.club.service;

import com.alibaba.fastjson.JSONObject;

public interface IPostService {

    public JSONObject createPost(JSONObject inform, int UserId ,int type);

    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId);

    public JSONObject viewPostInUser(int PostId, int UserId);

    public JSONObject viewPostList();

    public JSONObject viewPostsbyUser(int UserId);

    public JSONObject viewPostsSubscribed(int UserId);

    public JSONObject viewPostsbyClub(int ClubId,int UserId);

    public JSONObject ThumbOrUnthumb(int PostId, int UserId);

    public JSONObject viewPostsbyHabbit(int habbitId, int userId);
}
