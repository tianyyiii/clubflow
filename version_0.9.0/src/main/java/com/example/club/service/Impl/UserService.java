package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.UserDao;
import com.example.club.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        newuser.put("role", inform.getString("role"));
        // newuser.put("image", inform.getString("proflie"));
        newuser.put("image", "0");

        System.out.println(newuser);

//        int id = userdao.createuser(newuser);
        int statenow = userdao.createuser(newuser);

        //state = 1, 成功创建用户；state = 0, 该用户已存在；state = 2, 创建超时
        if (statenow == 1){
            //即使创建成功也可能出现加载不出来的情况，res里的state有可能是1或2. state=1,访问成功；state=2,访问超时
            JSONObject res = userdao.getUserbyName(inform.getString("name"));
            return res;
        }
        else {
            //该用户已存在（state=0）或者创建超时（state=2）
            JSONObject res = new JSONObject();
            res.put("state",statenow);
            return res;
        }

    }

    @Override
    public JSONObject modifyUser(JSONObject inform, int UserId) {

        int statenow = userdao.modifyuser(inform, UserId);
        //state = 1, 成功修改用户；state = 0, 不合规范，修改失败；state = 2, 修改超时
        if (statenow == 1){
            //有可能修改成功后访问超时，res的state= 2
            JSONObject res = userdao.getUserbyId(UserId);
            return res;
        }
        else {
            //state = 0, 不合规范，修改失败；修改超时，state=1
            JSONObject res = new JSONObject();
            res.put("state",statenow);
            return res;
        }
    }

    @Override
    public JSONObject deleteUser(int UserIdtoDelete){

        int statenow = userdao.deleteuser(UserIdtoDelete);
        //state = 1, 成功删除用户；state = 2, 删除超时
        if (statenow == 1){
            //有可能删除成功后访问超时，res的state=2
            JSONObject res = userdao.getUserbyId(UserIdtoDelete);
            return res;
        }
        else {
            //删除超时，state=2
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            res.put("UserIdtoDelete", UserIdtoDelete);
            return res;
        }

    }

    @Override
    public JSONObject viewUser(int UserId){

//        JSONObject res = new JSONObject();

        JSONObject user = userdao.getUserbyId(UserId);
//        res.put("id", user.getIntValue("id"));
//        res.put("name", user.getString("name"));
//        res.put("passwd", user.getString("passwd"));
//        res.put("role", user.getString("role"));
//        res.put("image", user.getString("image"));
//        //state = 1, 访问用户成功；state = 2，访问超时
//        res.put("state", user.getIntValue("state"));
//
//        res.put("res", user);

        return user;
    }

    @Override
    public JSONObject checkUser(String UserName, String password){

        int statenow = userdao.login(UserName, password);
        //statenow = 1, 成功登录；statenow = 0, 该用户不存在；statenow = 2, 登录超时；statenow = 3, 密码错误
        if (statenow == 1){
            //登录成功，但是有可能加载超时，res的state=2
            JSONObject res = userdao.getUserbyName(UserName);
            return res;
        }
        else{
            //用户不存在，state=0；登录超时，state=2；密码错误，state=3
            JSONObject res = new JSONObject();
            res.put("state",statenow);
            return res;
        }
    }


}
