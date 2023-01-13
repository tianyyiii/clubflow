package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;


public class ImageDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String FindImgbyId(int imageId){
        try{
            String sql = "select imageSrc from image";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            String res=list.get(0).get("name").toString();
            return res;
        }
        catch(RuntimeException e){
            String res="出现错误";
            return res;
        }
    }
}
