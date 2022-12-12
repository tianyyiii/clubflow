package com.example.club.dao;

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
    public String viewuser(Integer UserId){
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


}
