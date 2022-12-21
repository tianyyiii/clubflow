package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HabbitDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createhabbit(JSONObject inform){

        try{
            String habbitname = inform.getString("name");
            String sql = "select habbitName from habbit where habbitname=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, habbitname);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("habbitName").equals(habbitname))
                    return 0;
            }
            System.out.println(inform);
            jdbcTemplate.update("insert into habbit(habbitName,habbitInfo,createDate,creator,state,image) values(?,?,?,?,?,?)",
                    inform.getString("name"), inform.getString("info"), inform.getDate("date"),
                    inform.getInteger("creator"), 1, 1);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyhabbit(JSONObject inform, int HabbitId, int UserId){

        try{
            String newHabbitName = inform.getString("name");
            String sql = "select habbitName from habbit where habbitName=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, newHabbitName);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("habbitName").equals(newHabbitName))
                    return 0;
            }

            jdbcTemplate.update("update habbit set habbitName=?,habbitInfo=?,image=? where habbitId=?",
                    inform.getString("name"), inform.getString("inform"),1, HabbitId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }

    }

    public JSONObject getHabbitbyId(int HabbitId){
        try{
            String sql = "select * from habbit where habbitId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, HabbitId);
            Map<String,Object> habbit = list.get(0);
            JSONObject res = new JSONObject(habbit);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("habbitId", HabbitId);
            return res;
        }
    }

    public JSONObject getHabbitbyName(String HabbitName){
        try{
            String sql = "select * from habbit where habbitName=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, HabbitName);
            System.out.println("yes");
            Map<String,Object> habbit = list.get(0);
            JSONObject res = new JSONObject(habbit);
            System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("habbitId", HabbitName);
            return res;
        }
    }

    public List<Object> listmyhabbits(int UserId){
        /*        try catch需要重新改格式*/
        try{
            String sql = "select habbitid from habbitfan where fanid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
            List<Object> res = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                Map<String,Object> temp = list.get(i);
                res.add(temp.get("habbitId"));
            }
            return res;

        }
        catch(RuntimeException e){
            List<Object> res = null;
            return res;
        }

    }


}
