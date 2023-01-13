package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.club.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SubCommentDAO subCommentDAO;

    public int createcomment(JSONObject inform){
        try{
            System.out.println(inform);
            jdbcTemplate.update("insert into comment (commenter, post, context, commentDate, thumbs) values (?,?,?,?,?)",
                    inform.getIntValue("commenter"), inform.getIntValue("post"), inform.getString("context"),
                    inform.getDate("commentDate"), 0);
            return 1;
        }catch (RuntimeException e){
            return 2;
        }
    }

    //返回1表示已点赞，返回0表示未点赞
    public int isthumbed(int CommentId, int UserId){
        try{
            String sql = "select * from commnetthumb where thumberId=? and commnetId=?";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId,CommentId);
            if(list.isEmpty()){
                return 0;
            }
            else{
                return 1;
            }
        }catch (RuntimeException e){
            return 2;
        }

    }


    public JSONObject viewComment(int CommentId, int UserId){
        String sql = "select * from comment where commentId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, CommentId);
        Map<String, Object> comment = list.get(0);
        JSONObject res = new JSONObject(comment);
        res.put("isthumbed", isthumbed(CommentId, UserId));
        return res;
    }


    //这个函数需要显示某post下所有的comments，并根据用户id显示是否已点赞
    public List<JSONObject> viewCommentsByPostId(int PostId, int UserId){
        String sql = "select * from comment where post=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, PostId);
        List<JSONObject> res = new ArrayList<>();
        for(int i=0;i<list.size();++i){
            Map<String, Object> tmp1 = list.get(i);
            int comId = (int) tmp1.get("commentId");
            JSONObject tmp = viewComment(comId, UserId);
            res.add(tmp);
        }
        return res;
    }

    public int deleteComment(int CommentId){
        try{
            jdbcTemplate.update("delete from comment where commentId=?", CommentId);
            jdbcTemplate.update("delete from subcomment where comment=?", CommentId);
            return 1;
        }catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyComment(JSONObject inform, int CommentId){
        try{System.out.println(inform);
            jdbcTemplate.update("update comment set context=?,commentDate=? where commentId=?",
                    inform.getString("context"), inform.getDate("commentDate"), CommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;

        }
    }

    public int thumb(int CommentId, int UserId){
        try{
            Date date = new Date();
            jdbcTemplate.update("insert into commnetthumb(commnetId, thumberId, lastThumbDate, state)values(?,?,?,?)",
                    CommentId, UserId, date, 1);
            jdbcTemplate.update("update comment set thumbs=thumbs+1 where commentId=?", CommentId);

            return 1;

        }catch (RuntimeException e){
            return 2;
        }

    }

    public int unthumb(int CommentId, int UserId){
        try{
            jdbcTemplate.update("delete from commnetthumb where commnetId=? AND thumberId=?",CommentId, UserId);
            jdbcTemplate.update("update comment set thumbs=thumbs-1 where commentId=?", CommentId);

            return 1;

        }catch (RuntimeException e){
            return 2;
        }
    }

    public int Check(int CommentId, int UserId){
        String sql = "select commenter from comment where commentId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, CommentId);
        Map<String, Object> comment = list.get(0);
        if(comment.get("commenter").equals(UserId)){
            return 1;
        }
        else{
            return 0;
        }
    }

}
