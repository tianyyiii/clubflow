package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;
    Random r=new Random();


    public JSONObject createUser(JSONObject inform){
        JSONObject inform1=new JSONObject();
        inform1.put("id",r.nextInt(2000));
        Integer state=userdao.createuser(inform);
        inform1.put("state",1);
        inform1.put("role",inform.getString("role"));
        inform1.put("name",inform.getString("name"));
        inform1.put("passwd",inform.getString("passwd"));
        inform1.put("image",inform.getString("profile"));
        int statenow=userdao.createuser(inform1);
        JSONObject res=new JSONObject();
        res.put("state",statenow);
        return res;
    }


    public JSONObject deleteUser(int UserId){
        JSONObject temp=new JSONObject();
        try{

            temp.put("state",1);
            return temp;
        }
        catch (RuntimeException e){
            temp.put("state",0);
            return temp;
        }
    }

/*    @Override
    public JSONObject modifyUser(JSONObject inform, int UserId){
        JSONObject res=new JSONObject();
        Integer state= userdao.modifyuser(inform, UserId);
        res.put("state",state);
        return res;

    }*/

    public JSONObject viewUser(int UserId){
        JSONObject res=new JSONObject();
        JSONObject res1=userdao.getuser(UserId);
        res.put("id",res1.getIntValue("id"));
        res.put("name",res1.getString("name"));
        res.put("passwd",res1.getString("passwd"));
        res.put("role",res1.getString("role"));
        res.put("image",res1.getString("image"));
        res.put("res1",res1);
        return res;
    }
    public JSONObject checkUser(String UserName,String password){
        JSONObject res=new JSONObject();
        return res;
    }


}
