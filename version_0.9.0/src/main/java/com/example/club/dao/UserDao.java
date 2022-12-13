package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createuser(JSONObject inform){

        try{
            String username = inform.getString("name");
            String sql = "select name from account";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("name").equals(username))
                    return 0;
            }

            System.out.println(inform);
//            Integer id=list.size();
            jdbcTemplate.update("insert into account(name, passwd, role, state) values(?,?,?,?,?)",
                    //inform.getInteger("id"),inform.getString("name"), inform.getString("passwd"),
                    inform.getString("name"), inform.getString("passwd"), inform.getInteger("role"), 1);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyuser(JSONObject inform, int UserId){

        try{
            String newUserName = inform.getString("name");
            String sql = "select name from club";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, newUserName);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("clubName").equals(newUserName))
                    return 0;
            }

            jdbcTemplate.update("update user set name=?, passwd=?, image=? where id=?",
                    inform.getString("name"), inform.getString("passwd"),inform.getString("profile"), UserId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int deleteuser(int UserIdtoDelete){
        try {
            jdbcTemplate.update("delete from account where id=?", UserIdtoDelete);
            return 1;
        }
        catch (RuntimeException e){
            return 2;
        }
    }

    public String getusername(int UserId){
        try{
            String sql="select name from account where id=?";
            List<Map<String, Object>> list=jdbcTemplate.queryForList(sql, UserId);
            String res=list.get(0).get("name").toString();

            return res;
        }
        catch(RuntimeException e){
            String res="出现错误";
            return res;
        }
    }

    public JSONObject getUserbyId(int UserId){
        try{
            String sql = "select * from account where id=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserId);
            System.out.println("yes");
            Map<String,Object> user = list.get(0);
            JSONObject res = new JSONObject(user);
//            System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("id", UserId);
            return res;
        }
    }

    public JSONObject getUserbyName(String UserName){
        try{
            String sql = "select * from account where name=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserName);
            System.out.println("yes");
            Map<String,Object> res1 = list.get(0);
            JSONObject res = new JSONObject(res1);

            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            res.put("id", UserName);
            return res;
        }
    }

    public int login(String UserName, String password){
        try {
            String sql = "select * from account where passwd=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, password);
            System.out.println(list);
//            int result=-2;
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("name").equals(UserName)){
                    if (tmp.get("passwd").equals(password)) {
//                        result = Integer.valueOf(tmp.get("id").toString());
//                        return result;
                        return 1;
                    }
                    else
                        return 3; //密码不对
                }
            }
            return 0; //用户不存在
        }
        catch (RuntimeException e){
            return 2;
        }
    }

}
