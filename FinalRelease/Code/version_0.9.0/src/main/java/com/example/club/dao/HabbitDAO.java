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
            String sql = "select habbitName from habbit where habbitName=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, habbitname);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("habbitName").equals(habbitname))
                    return 0;
            }
            System.out.println(inform);

            jdbcTemplate.update("insert into habbit(habbitName,habbitInfo,createDate,creator, state,image,publicationNum,fansNum,commentsNum,announcement)values(?,?,?,?,?,?,?,?,?,?)",
                    inform.getString("name"), inform.getString("info"), inform.getDate("date"),
                    inform.getInteger("creator"), 1, inform.getString("image"),0,0,0,inform.getString("announcement"));
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyhabbit(JSONObject inform, int HabbitId, int UserId){

        try{
            String newHabbitName = inform.getString("name");
            String sql = "select habbitName,habbitId from habbit";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("habbitName").equals(newHabbitName) && (Integer)tmp.get("habbitId")!=HabbitId)
                    return 0;
            }

            jdbcTemplate.update("update habbit set habbitName=?,habbitInfo=?,image=? where habbitId=?",
                    inform.getString("name"), inform.getString("inform"),inform.getString("image"), HabbitId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }

    }

    public List<Object> getHabbitbyCreatorId(int UserId){
        try{
            String sql = "select habbitId from habbit where creator=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserId);
            List<Object> res = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                Map<String,Object> temp = list.get(i);
                res.add(temp.get("habbitId"));
            }

            //System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            List<Object> res = null;
            return res;
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
            String sql = "select habbitId from habbitfan where fanid=?";
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

    public List<Object> listallhabbits(){
        try{
            String sql = "select habbitId from habbit";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
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

    public List<Object> listclubfans(int HabbitId){
        /*        try catch需要重新改格式*/
        try{
            String sql = "select fanid from habbitfan where habbitid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, HabbitId);
            List<Object> res = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                Map<String,Object> temp = list.get(i);
                res.add(temp.get("fanid"));
            }
            return res;

        }
        catch(RuntimeException e){
            List<Object> res = null;
            return res;
        }


    }
    public String viewAnnouncementbyHabbitId(int HabbitId){
        try{
            String sql = "select announcement from habbit where habbitid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, HabbitId);
            String res= list.get(0).toString();
            return res;
        }
        catch(RuntimeException e){
            return "dao error";
        }
    }

    public int editAnnouncementbyHabbitId(String inform,int HabbitId){
        try{
            String sql=" update habbit set announcement=? where habbitId=?";
            jdbcTemplate.update(sql,inform,HabbitId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public Integer subscribeAdd(Integer id,Integer subscribes){
        try{
            jdbcTemplate.update("update habbit set fansNum=? where habbitId=?",subscribes,id);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }

    public int subscribeMinus(Integer id,Integer subscribes){
        try{
            jdbcTemplate.update("update habbit set fansNum=? where habbitId=?",subscribes,id);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }




    public int createSubscribe(JSONObject inform){
        int state=1;
        try{
            System.out.println(inform);
            jdbcTemplate.update("insert into habbitfan(habbitid,fanid,joinDate,state) values(?,?,?,?)"
                    ,inform.getInteger("habbitid"),inform.getInteger("fanid"),inform.getDate("date")
                    ,inform.getInteger("state"));
            return state;

        }
        catch(RuntimeException e){
            state=0;
            return state;
        }

    }

    public int deleteSubscribe(Integer HabbitId,Integer UserId){
        try{
            jdbcTemplate.update("delete from habbitfan where habbitid=? and fanid=?", HabbitId,UserId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public int checkSubscribebyUser(Integer HabbitId,Integer UserId){
        try{
            String sql = "select * from habbitfan where habbitid=? and fanid=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,HabbitId,UserId);
            if (list.isEmpty()){
                return 2;
            }
            else{
                return 1;
            }
        }
        catch(RuntimeException e){
            return 0;
        }

    }





}
