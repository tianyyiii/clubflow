package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClubDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createclub(JSONObject inform){
        JSONObject res=new JSONObject();
         try{jdbcTemplate.update("insert into club(clubId,clubName,clubInfo,createDate,creator,state,image)values(?,?,?,?,?,?,?)"
        ,inform.getInteger("id"),inform.getString("name"),inform.getString("info"),
                inform.getString("date"),inform.getString("creator"),inform.getInteger("state"),
                inform.getString("image"));
             return 1;
         }
         catch(RuntimeException e){
             return 0;
        }
    }
    public int modifyclub(JSONObject inform,int ClubId){
        try{
            jdbcTemplate.update("update club set clubName=?,clubInfo=?,image=? where id=?",inform.getString("name"),
                    inform.getString("info"),inform.getString("image"),ClubId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }
    public JSONObject viewclub(int ClubId){
        try{

        }
    }


}
