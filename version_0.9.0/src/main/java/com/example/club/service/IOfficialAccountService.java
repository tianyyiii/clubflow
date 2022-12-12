package com.example.club.service;

import com.alibaba.fastjson.JSONObject;
import com.example.club.DAO.AccountDAO;
import com.example.club.dao.ClubDAO;
import com.example.club.dao.ClubPostDAO;
import jakarta.validation.constraints.Max;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

public interface IOfficialAccountService {
    public JSONObject createUser(@RequestBody JSONObject inform);
    public JSONObject modifyUser(@RequestBody JSONObject inform, @Max(value=10,message="not more than 10") @PathVariable("UserId")int UserId);

    public JSONObject deleteUser(int UserIdtoModify,int UserId);

    public JSONObject checkUser(String UserName,String password);

}
