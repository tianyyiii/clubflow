package com.example.club.dao;

import co.elastic.clients.util.DateTime;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SubCommentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createSubComment(JSONObject inform){
        int res;
        System.out.println(inform.getInteger("subcommenter"));

/*        Integer a=jdbcTemplate.update("insert into subcomment(subcommentId,subcommenter,context,commnetDate,comment,replyWho,thumbs) values(?,?,?,?,?,?,?)"
            ,2,inform.getInteger("subcommenter"), inform.getString("context"), inform.getDate("date").toString(),
            inform.getInteger("comment"), 1,inform.getInteger("thumbs"));*/
        jdbcTemplate.update("insert into subcomment(subcommenter,context,commnetDate,comment,replyWho,thumbs)values(?,?,?,?,?,?)",
                (int)inform.getInteger("subcommenter"),inform.getString("context"),
                inform.getDate("date"),inform.getInteger("comment"),
                inform.getInteger("replyWho"),inform.getInteger("thumbs"));
        System.out.println("this is es");
        return 1;


    }
    public Integer modifySubComment(JSONObject inform,int SubCommentId){
        try{
            jdbcTemplate.update("update subcomment set context=?,commnetDate=?,replyWho=? where subcommentId=?",
                    inform.getString("context"), inform.getDate("commnetDate"),inform.getInteger("replyWho"), SubCommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;

        }
    }
    public Integer deleteSubComment(int SubCommentId){
        try{
            jdbcTemplate.update("delete from subcomment where subcommentId=?", SubCommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public Integer thumb(Integer id,Integer thumbs){
        try{
            jdbcTemplate.update("update subcomment set thumbs=? where subcommentId=?",thumbs,id);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }

    public Integer unthumb(Integer id,Integer thumbs){
        try{
            jdbcTemplate.update("update subcomment set thumbs=? where subcommentId=?",thumbs,id);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }

    }

    //返回1表示已点赞，返回0表示未点赞
    public int isthumbed(int SubcommentId, int UserId){
        String sql = "select * from subcommnetthumb where thumberId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
        for (int i=0;i<list.size();++i){
            Map<String, Object> tmp = list.get(i);
            if (tmp.get("subcommmentId").equals(SubcommentId)){
                return 1;
            }
        }
        return 0;
    }

    public JSONObject viewSubComment(int SubcommentId, int UserId){
        String sql = "select * from subcomment where subcommentId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
        Map<String, Object> subcomment = list.get(0);
        JSONObject res = new JSONObject(subcomment);
        res.put("isthumbed", isthumbed(SubcommentId, UserId));
        return res;

    }

    //这个函数需要显示某条主评论下所有的subcomments，并根据用户id显示是否已点赞
    public List<JSONObject> viewSubcommentsByCommentId(int CommentId, int UserId){
        String sql = "select subcommentId from subcomment where comment=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, CommentId);
        List<JSONObject> res = new ArrayList<>();
        for(int i=0;i<list.size();++i){
            Map<String, Object> tmp1 = list.get(i);
            int subId = (int) tmp1.get("subcommentId");
            JSONObject tmp = viewSubComment(subId, UserId);
            res.add(tmp);
        }
        return res;
    }

    public int createThumb(JSONObject inform){
        int state=1;
        try{
            System.out.println(inform);
            jdbcTemplate.update("insert into subcommnetthumb(subcommmentId,thumberId,lastThumbDate,state) values(?,?,?,?)"
                    ,inform.getInteger("subcommentid"),inform.getInteger("thumberId"),inform.getDate("date")
                    ,inform.getInteger("state"));
            return state;

        }
        catch(RuntimeException e){
            state=2;
            return state;
        }

    }

    public int deleteThumb(Integer SubCommentId,Integer ThumberId){
        try{
            jdbcTemplate.update("delete from subcommnetthumb where subcommmentId=? and thumberId=?", SubCommentId,ThumberId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public int checkThumbbyUser(Integer SubCommentId,Integer UserId){
        try{
            String sql = "select * from subcommnetthumb where subcommmentId=? and thumberId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,SubCommentId,UserId);
            if (list.isEmpty()){
                return 0;
            }
            else{
                return 1;
            }
        }
        catch(RuntimeException e){
            return 2;
        }

    }



}
