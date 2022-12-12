package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createuser(JSONObject inform){
        JSONObject tmp=new JSONObject();
        try{jdbcTemplate.update("insert into account(id, name, passwd, role, state, image)values(?,?,?,?,?,?,?)"
                ,inform.getInteger("id"),inform.getString("name"), inform.getString("passwd"),
                inform.getInteger("role"), inform.getInteger("state"), inform.getString("image"));
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public String username(int UserId){
        try{
            String sql="select name from account where id=?";
            List<Map<String, Object>> list=jdbcTemplate.queryForList(sql,UserId);
            String res=list.get(0).get("name").toString();

            return res;
        }
        catch(RuntimeException e){
            String res="出现错误";
            return res;
        }
    }

    public JSONObject getuser(int UserId){
        try{
            String sql="select * from user where userId=?";
            List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,UserId);
            System.out.println("yes");
            Map<String,Object> res1= list.get(0);
            JSONObject res=new JSONObject(res1);
            System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",0);
            return res;
        }
    }
}
