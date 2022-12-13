package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson2.schema.JSONSchema.Type.Null;
@Repository
public class ClubPostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userdao;

    public int createPost(JSONObject inform){

        try{
            String clubname = inform.getString("clubName");
            String posttitle = inform.getString("title");

            String sql = "select title, club from post";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, clubname);
            for (int i=0; i<list.size(); ++i){
                Map post = list.get(i);
                if (post.get("title").equals(posttitle))
                    return 0;
            }

            jdbcTemplate.update("insert into post(creator,context,thumbs,createDate,lastModifyDate,club,image)values(?,?,?,?,?,?,?,?)",
                inform.getString("name"), inform.getString("context"),
                inform.getInteger("thumbs"),inform.getString("date"),inform.getString("datemodify"),
                inform.getString("club"),inform.getString("image"));
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int modifypost(JSONObject inform,int PostId,int UserId){

        try{
            String newPostName = inform.getString("title");
            String sql = "select title from post where name=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, userdao.getusername(UserId));
            for (int i=0; i<list.size(); ++i){
                Map tmp = list.get(i);
                if (tmp.get("title").equals(newPostName))
                    return 0;
            }

            Date datemodify = new Date();
            jdbcTemplate.update("update post set title=?,context=?,image=?,datemodify=? where postId=?",
                    inform.getString("title"), inform.getString("context"),inform.getString("profile"),datemodify.toString(),PostId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public JSONObject getPostbyId(int PostId){
        try{
            String sql = "select * from post where postId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,PostId);
            Map<String,Object> post = list.get(0);
            JSONObject res = new JSONObject(post);

            return res;
        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",2);
            return res;
        }
    }

    public JSONObject getPostbyNameANDCreator(String ClubName, String PostTitle){
        try{
            String sql = "select * from post where title=? AND club=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, PostTitle, ClubName);
            Map<String,Object> post = list.get(0);
            JSONObject res = new JSONObject(post);
            return res;
        }
        catch(RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state",2);
            return res;
        }
    }

    public List<Map<String,Object>> listUserPosts(int UserId){
        try{
            JSONObject res = new JSONObject();
            String sql = "select * from post where postId=?";
            // System.out.println(sql);
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, UserId);
            // System.out.println(list);
            return list;
        }
        catch(RuntimeException e){
            List<Map<String,Object>> res = null;
            return res;
        }
    }

    public List<Map<String,Object>> listClubPosts(int ClubId){
        try{
            JSONObject res = new JSONObject();
            String sql = "select * from post where club=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, ClubId);
//            for (int i=0; i<list.size(); i++){
//                Map<String,Object> post = list.get(0);
//                JSONObject temp = new JSONObject(post);
//                res.put("post"+Integer.toString(i),temp);
//
//            }
//            return res;
            return list;
        }
        catch(RuntimeException e){
//            JSONObject res=new JSONObject();
//            res.put("state",2);
//            return res;
            List<Map<String,Object>> res = null;
            return res;
        }

    }

}
