package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson2.schema.JSONSchema.Type.Null;
@Repository
public class ClubPostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int createPost(JSONObject inform){
        JSONObject res=new JSONObject();
        try{jdbcTemplate.update("insert into post(postId,creator,context,thumbs,createDate,lastModifyDate,club,image)values(?,?,?,?,?,?,?,?)"
                ,inform.getInteger("id"),inform.getString("name"),inform.getString("context"),
                inform.getInteger("thumbs"),inform.getString("date"),inform.getString("datemodify"),
                inform.getString("club"),inform.getString("image"));
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }
    public JSONObject viewPost(int PostId){
        try{
            String sql="select * from post where postId=?";
            List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,PostId);
            Map<String,Object> res1= list.get(0);
            JSONObject res=new JSONObject(res1);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",0);
            return res;
        }
    }
    public List<Map<String,Object>> viewPostbyUser(int UserId){
        try{
            JSONObject res=new JSONObject();
            String sql="select * from post where postId=?";
            List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,UserId);


            return list;
        }
        catch(RuntimeException e){
            List<Map<String,Object>> a = null;

            return a;
        }
    }
    public JSONObject viewPostbyClub(int ClubId){
        try{
            JSONObject res=new JSONObject();
            String sql="select * from post where club=?";
            List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,ClubId);
            for (int i=0;i<list.size();i++){
                Map<String,Object> res1= list.get(0);
                JSONObject temp=new JSONObject(res1);
                res.put("post"+Integer.toString(i),temp);

            }

            return res;
        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",0);
            return res;
        }
    }

}
