package com.example.club.service;

import com.alibaba.fastjson.JSONObject;

public interface IPostService {

    public JSONObject createPost(JSONObject inform, int UserId);

    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId);

    public JSONObject viewPostInUser(int PostId, int UserId);

    public JSONObject viewPostsbyUser(int UserId);

    public JSONObject viewPostsbyClub(int ClubId,int UserId);

    public JSONObject ThumbOrUnthumb(int PostId, int UserId);
}
