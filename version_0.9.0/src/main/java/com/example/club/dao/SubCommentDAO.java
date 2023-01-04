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
        System.out.println(inform.getInteger("subcommenter"));
        try{
            System.out.println(inform);
            jdbcTemplate.update("insert into subcomment(subcommenter,context,commentDate,comment,replyWho,thumbs)values(?,?,?,?,?,?)",
                    inform.getInteger("subcommenter"),inform.getString("context"),
                    inform.getDate("date"),inform.getInteger("comment"),
                    inform.getInteger("replyWho"),inform.getInteger("thumbs"));
            return 1;
        }catch (RuntimeException e){
            return 2;
        }

    }

    public Integer modifySubComment(JSONObject inform,int SubCommentId){
        try{
            jdbcTemplate.update("update subcomment set context=?,commentDate=?,replyWho=? where subcommentId=?",
                    inform.getString("context"), inform.getDate("commnetDate"),inform.getInteger("replyWho"), SubCommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;

        }
    }

    public Integer deleteSubComment(int SubCommentId){
        try{
            System.out.println(SubCommentId);
            jdbcTemplate.update("delete from subcommnetthumb where subcommmentId=?",SubCommentId);
            jdbcTemplate.update("delete from subcomment where subcommentId=?",SubCommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
        }
    }

    public Integer thumb(Integer id,Integer thumbs){
        try{
            jdbcTemplate.update("update subcomment set thumbs=thumbs+1 where subcommentId=?",thumbs,id);
            return 1;
        }
        catch(RuntimeException e){
            return 2;
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
        try{
            String sql = "select * from subcommnetthumb where subcommmentId=? and thumberId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,SubcommentId,UserId);
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

    public JSONObject viewSubComment(int SubcommentId, int UserId){
        String sql = "select * from subcomment where subcommentId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, SubcommentId);
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
            int subcommentId = (int) tmp1.get("subcommentId");
            JSONObject tmp = viewSubComment(subcommentId, UserId);
            res.add(tmp);
        }
        return res;
    }

    public int createThumb(JSONObject inform){
        try{
            System.out.println(inform);
            jdbcTemplate.update("insert into subcommnetthumb(subcommmentId,thumberId,lastThumbDate,state) values(?,?,?,?)"
                    ,inform.getInteger("subcommentId"),inform.getInteger("thumberId"),inform.getDate("date")
                    ,inform.getInteger("state"));
            jdbcTemplate.update("update subcomment set thumbs=thumbs+1 where subcommentId=?",inform.getInteger("subcommentId"));
            return 1;

        }
        catch(RuntimeException e){
            return 2;
        }

    }

    public int deleteThumb(Integer SubCommentId,Integer ThumberId){
        try{
            jdbcTemplate.update("delete from subcommnetthumb where subcommmentId=? and thumberId=?", SubCommentId,ThumberId);
            jdbcTemplate.update("update subcomment set thumbs=thumbs-1 where subcommentId=?",SubCommentId);
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
