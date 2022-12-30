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
        String sql = "select * from commnetthumb where thumberId=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, UserId);
        for (int i=0;i<list.size();++i){
            Map<String, Object> tmp = list.get(i);
            if (tmp.get("commnetId").equals(CommentId)){
                return 1;
            }
        }
        return 0;
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
            jdbcTemplate.update("delete * from comment where commentId=?", CommentId);
            jdbcTemplate.update("delete * from subcomment where comment=?", CommentId);
            return 1;
        }catch(RuntimeException e){
            return 2;
        }
    }

    public int modifyComment(JSONObject inform, int CommentId){
        try{
            jdbcTemplate.update("update comment set context=?,commnetDate=?,replyWho=? where commentId=?",
                    inform.getString("context"), inform.getDate("commnetDate"),inform.getInteger("replyWho"), CommentId);
            return 1;
        }
        catch(RuntimeException e){
            return 2;

        }
    }

    public JSONObject thumb(int CommentId, int UserId){
        try{
            Date date = new Date();
            jdbcTemplate.update("insert into commnetthumb(commnetId, thumberId, lastThumbDate, state)",
                    CommentId, UserId, date, 1);
            jdbcTemplate.update("update comment set thumbs=thumbs+1 where commentId=?", CommentId);

            JSONObject res = viewComment(CommentId, UserId);
            return res;

        }catch (RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }

    }

    public JSONObject unthumb(int CommentId, int UserId){
        try{
            jdbcTemplate.update("delete * from commnetthumb where commnetId=? AND thumberId=?",CommentId, UserId);
            jdbcTemplate.update("update comment set thumbs=thumbs-1 where commentId=?", CommentId);

            JSONObject res = viewComment(CommentId, UserId);
            return res;

        }catch (RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }

}
