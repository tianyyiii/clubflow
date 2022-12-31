package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ClubDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createclub(JSONObject inform){

        try{

            String clubname = inform.getString("name");
            String sql = "select clubName from club where clubName=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, clubname);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("clubName").equals(clubname))
                    return 0;
            }

            jdbcTemplate.update("insert into club(clubName,clubInfo,createDate,creator, state,image,publicationsNum,fansNum,commentsNum)values(?,?,?,?,?,?,?,?,?)",
                    inform.getString("name"), inform.getString("info"), inform.getDate("date"),
                    inform.getInteger("creator"), 1, 1,0,0,0);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyclub(JSONObject inform, int ClubId, int UserId){

        try{
            String newClubName = inform.getString("name");
            String sql = "select clubId,clubName from club";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("clubName").equals(newClubName) && (Integer)tmp.get("clubId")!=ClubId)
                    return 0;
            }

            jdbcTemplate.update("update club set clubName=?,clubInfo=?,image=? where clubId=?",
                    inform.getString("name"), inform.getString("inform"),inform.getString("image"), ClubId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }

    }

    public JSONObject getClubbyCreatorId(int UserId){
        try{
            String sql = "select * from club where creator=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserId);
            Map<String,Object> club = list.get(0);
            JSONObject res = new JSONObject(club);

            //System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("UserId", UserId);
            return res;
        }
    }

    public JSONObject getClubbyId(int ClubId){
        try{
            String sql = "select * from club where clubId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, ClubId);
            Map<String,Object> club = list.get(0);
            JSONObject res = new JSONObject(club);

            //System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("clubId", ClubId);
            return res;
        }
    }

    public JSONObject getClubbyName(String ClubName){
        try{
            String sql = "select * from club where clubName=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, ClubName);
            System.out.println("yes");
            Map<String,Object> club = list.get(0);
            JSONObject res = new JSONObject(club);
            System.out.println(res);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            res.put("clubId", ClubName);
            return res;
        }
    }

    public List<Object> listmyclubs(int UserId){
        /*        try catch需要重新改格式*/
        try{
            String sql = "select clubId from clubfan where fanid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
            List<Object> res = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                Map<String,Object> temp = list.get(i);
                res.add(temp.get("clubId"));
            }
            return res;

        }
        catch(RuntimeException e){
            List<Object> res = null;
            return res;
        }


    }

    public List<Object> listallclubs(){
        try{
            String sql = "select clubId from club";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
            List<Object> res = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                Map<String,Object> temp = list.get(i);
                res.add(temp.get("clubId"));
            }
            return res;
        }
        catch(RuntimeException e){
            List<Object> res = null;
            return res;
        }

    }


    public List<Object> listclubfans(int ClubId){
        /*        try catch需要重新改格式*/
        try{
            String sql = "select fanid from clubfan where clubid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, ClubId);
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

    public String viewAnnouncementbyClubId(int ClubId){
        try{
            String sql = "select announcement from club where clubid=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, ClubId);
            String res= list.get(0).toString();
            return res;
        }
        catch(RuntimeException e){
            return "dao error";
        }
    }

    public int editAnnouncementbyClubId(String inform,int ClubId){
        try{
            String sql=" update club set announcement=? where clubId=?";
            jdbcTemplate.update(sql,inform,ClubId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public Integer subscribeAdd(Integer id,Integer subscribes){
        try{
            jdbcTemplate.update("update club set fansNum=? where clubId=?",subscribes,id);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }

    public int subscribeMinus(Integer id,Integer subscribes){
        try{
            jdbcTemplate.update("update club set fansNum=? where clubId=?",subscribes,id);
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
            jdbcTemplate.update("insert into clubfan(clubid,fanid,joinDate,state) values(?,?,?,?)"
                    ,inform.getInteger("clubid"),inform.getInteger("fanid"),inform.getDate("date")
                    ,inform.getInteger("state"));
            return state;

        }
        catch(RuntimeException e){
            state=0;
            return state;
        }

    }

    public int deleteSubscribe(Integer ClubId,Integer UserId){
        try{
            jdbcTemplate.update("delete from clubfan where clubid=? and fanid=?", ClubId,UserId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public int checkSubscribebyUser(Integer ClubId,Integer UserId){
        try{
            String sql = "select * from clubfan where clubid=? and fanid=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,ClubId,UserId);
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
