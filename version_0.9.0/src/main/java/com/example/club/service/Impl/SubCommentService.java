package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.SubCommentDAO;
import com.example.club.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SubCommentService {
    @Autowired
    private SubCommentDAO subCommentDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JSONObject createSubComment(JSONObject inform,Integer CommentId){
        JSONObject temp=new JSONObject();
        Date date = new Date();
        temp.put("subcommenter",inform.get("UserId"));
        temp.put("context",inform.get("Context"));
        temp.put("date", date);
        temp.put("comment",CommentId);
        temp.put("replyWho",userDao.getUserbyName((String) inform.get("ReplyWho")).get("id"));
        temp.put("thumbs",0);
        int state;
        try{
            subCommentDAO.createSubComment(temp);
            state=1;
            System.out.println("yes");
        }
        catch(RuntimeException e){
            state=0;
        }
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;



    }

    public JSONObject modifySubComment(JSONObject inform,Integer SubCommentId){
        JSONObject temp=new JSONObject();
        Date date=new Date();
        temp.put("context",inform.get("Context"));
        temp.put("commnetDate",date);
        temp.put("replyWho",userDao.getUserbyName((String) inform.get("ReplyWho")).get("id"));
        int state;
        try{
            subCommentDAO.modifySubComment(temp,SubCommentId);
            state=1;
        }
        catch(RuntimeException e){
            state=0;
        }
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;

    }

    public JSONObject deleteSubComment(Integer SubCommentId){
        int state;
        try{
            subCommentDAO.deleteSubComment(SubCommentId);
            state=1;
        }
        catch(RuntimeException e){
            state=0;
        }
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;

    }

/*这里的返回格式需要再改变*/
    public JSONObject viewSubCommentbyComment(Integer CommentId,Integer UserId){
        JSONObject res=new JSONObject();
        String sql = "select * from subcomment where subcommentId=?";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, CommentId);
        for (int i=0;i<list.size();i++){
            Map<String,Object> res1= list.get(i);
            JSONObject temp=new JSONObject(res1);
            int thumbstate= subCommentDAO.checkThumbbyUser((Integer) temp.get("subcommentId"),UserId);
            temp.put("thumbstate",thumbstate);
            res.put("subcomment"+Integer.toString(i),temp);

        }
        return res;
    }


    public JSONObject thumb(Integer SubCommentId,Integer UserId){
        JSONObject res=new JSONObject();
        if (subCommentDAO.checkThumbbyUser(SubCommentId,UserId)==1){
            res.put("state",0);
            res.put("error","already thumbed");
            return res;
        }
        else{
        JSONObject inform=subCommentDAO.viewSubComment(SubCommentId);
        int thumbs= (int) inform.get("thumbs");
        thumbs=thumbs+1;
        int state= subCommentDAO.thumb(SubCommentId,thumbs);
        JSONObject temp=new JSONObject();
        Date date=new Date();
        temp.put("subcommentid",SubCommentId);
        temp.put("thumberId",UserId);
        temp.put("state",1);
        temp.put("date",date);
        subCommentDAO.createThumb(temp);
        res.put("state",1);
        return res;}

    }

    public JSONObject unthumb(Integer SubCommentId,Integer UserId){
        JSONObject res=new JSONObject();
        if (subCommentDAO.checkThumbbyUser(SubCommentId,UserId)==2){
            res.put("state",0);
            res.put("error","haven't thumbed");
            return res;
        }
        else{
        JSONObject inform=subCommentDAO.viewSubComment(SubCommentId);
        int thumbs= (int) inform.get("thumbs");
        thumbs=thumbs-1;
        int state= subCommentDAO.unthumb(SubCommentId,thumbs);
        subCommentDAO.deleteThumb(SubCommentId);
        res.put("state",1);
        return res;}
    }


}
