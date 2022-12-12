package com.example.club.service;

import com.alibaba.fastjson.JSONObject;

public interface IUserService {

    public JSONObject createUser(JSONObject inform);

    public void deleteUser(int UserId);

    public JSONObject modifyUser(JSONObject inform, int UserId);

    public JSONObject viewUser(int UserId);

}
