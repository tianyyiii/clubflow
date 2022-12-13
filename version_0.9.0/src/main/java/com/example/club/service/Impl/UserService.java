package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.UserDao;
import com.example.club.entity.User;
import com.example.club.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userdao;

    @Override
    public JSONObject createUser(JSONObject inform){
        System.out.println(inform);

        JSONObject newuser = new JSONObject();
        newuser.put("name",inform.getString("name"));
        newuser.put("passwd",inform.getString("passwd"));
        newuser.put("role",inform.getString("role"));
        // newuser.put("image", inform.getString("proflie"));
        newuser.put("image", "0");

        System.out.println(newuser);

        int id = userdao.createuser(newuser);

        int state = id<0?(-id):0;
        int statenow = state;
        if(state==0){statenow=1;}
        if(state==1){statenow=0;}

        JSONObject res = new JSONObject();
        //state = 1, 成功创建用户；state = 0, 该用户已存在；state = 2, 创建超时
        res.put("state",statenow);
        res.put("id", id);
        // res.put("name", inform.getString("name"));
        return res;
    }

    @Override
    public JSONObject deleteUser(int UserIdtoDelete){
        JSONObject res = new JSONObject();

        int statenow = userdao.deleteuser(UserIdtoDelete);
        res.put("state", statenow);
        res.put("UserIdtoDelete", UserIdtoDelete);
        return res;
    }

    @Override
    public JSONObject modifyUser(JSONObject inform, int UserId) {
        JSONObject res = new JSONObject();
        int statenow = userdao.modifyuser(inform, UserId);
        res.put("state", statenow);
        res.put("id", UserId);
        return res;
    }

    @Override
    public JSONObject viewUser(int UserId){

        JSONObject res = new JSONObject();

        JSONObject user = userdao.getuser(UserId);
        res.put("id", user.getIntValue("id"));
        res.put("name", user.getString("name"));
        res.put("passwd", user.getString("passwd"));
        res.put("role", user.getString("role"));
        res.put("image", user.getString("image"));
        res.put("res1", user);

        return res;
    }

    @Override
    public JSONObject checkUser(String UserName, String password){

        JSONObject res = new JSONObject();

        int id = userdao.login(UserName, password);
        int state = id<0?(-id):0;
        int statenow=state;
        if(state==0){
            statenow=1;
        }
        if(state==1){
            statenow=0;
        }
        //state = 1, 成功登录；state = 0, 该用户不存在；state = 2, 登录超时；state = 3, 密码错误
        res.put("state", statenow);
        res.put("UserId",id);
        System.out.println(res);
        return res;
    }


}
