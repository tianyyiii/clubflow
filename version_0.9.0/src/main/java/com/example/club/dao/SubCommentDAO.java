package com.example.club.dao;

import co.elastic.clients.util.DateTime;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public JSONObject viewSubComment(Integer id){
        try{
            String sql = "select * from subcomment where subcommentId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, id);
            Map<String,Object> res1 = list.get(0);
            JSONObject res = new JSONObject(res1);
            return res;

        }
        catch(RuntimeException e){
            JSONObject res=new JSONObject();
            res.put("state",0);
            return res;
        }

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
            state=0;
            return state;
        }

    }

    public int deleteThumb(Integer SubCommentId){
        try{
            jdbcTemplate.update("delete from subcommnetthumb where subcommmentId=?", SubCommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    public int checkThumbbyUser(Integer SubCommentId,Integer UserId){
        try{
            String sql = "select * from subcommnetthumb where subcommmentId=? and thumberId=?";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,SubCommentId,UserId);
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
