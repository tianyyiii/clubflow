package com.example.club.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

    public JSONObject createUser(JSONObject inform);

    public JSONObject modifyUser(JSONObject inform, int UserId);

    public JSONObject deleteUser(int UserId);

    public JSONObject viewUser(int UserIdtoView);

    public JSONObject checkUser(String UserName,String password);

}
