package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClubDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createclub(JSONObject inform){
        System.out.println("yes");
        System.out.println(inform);
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
                    inform.getString("inform"),inform.getString("profile"),ClubId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }
    public JSONObject view(int ClubId){
        try{
            String sql="select * from club where clubId=?";
            List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,ClubId);
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
    public List<Object> viewbyAccount(int UserId){
/*        try catch需要重新改格式*/
        try{
            String sql="select clubid from clubfan where fanid=?";
            List<Map<String, Object>> list=jdbcTemplate.queryForList(sql,UserId);
            List<Object> res = null;
            for (int i=0;i<list.size();i++){
                Map<String,Object> temp=list.get(i);
                res.add(temp.get("clubid"));

            }
            return res;



        }
        catch(RuntimeException e){
            List<Object> res = null;

            return res;
        }

    }


}
