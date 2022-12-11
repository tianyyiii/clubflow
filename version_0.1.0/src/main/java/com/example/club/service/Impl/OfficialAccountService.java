package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.DAO.AccountDAO;
import com.example.club.DAO.ClubDAO;
import com.example.club.DAO.ClubPostDAO;
import com.example.club.entity.Club;
import com.example.club.service.IClubService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

public class OfficialAccountService {

    @Autowired
    private AccountDAO accdao;

    @Override
    public JSONObject createUser(@RequestBody JSONObject inform) {
        return accdao.createUser(inform);
    }

    @Override
    public JSONObject modifyUser(@RequestBody JSONObject inform, @Max(value=10,message="not more than 10") @PathVariable("UserId")int UserId){
        return accdao.modifyUser(inform, UserId);
    }

    @Override
    public JSONObject deleteUser(int UserIdtoModify,int UserId){
        return accdao.deleteUser(UserIdtoModify, UserId);
    }

    @Override
    public JSONObject checkUser(String UserName,String password){
        return accdao.checkUser(UserName, password);
    }

}
