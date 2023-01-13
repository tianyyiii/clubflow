package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.CommentDAO;
import com.example.club.dao.SubCommentDAO;
import com.example.club.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubCommentService {
    @Autowired
    private SubCommentDAO subCommentDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JSONObject createSubComment(JSONObject inform, Integer CommentId){
        JSONObject temp = new JSONObject();
        Date date = new Date();
        temp.put("subcommenter", inform.get("UserId"));
        temp.put("context", inform.get("Context"));
        temp.put("date", date);
        temp.put("comment", CommentId);
        int Replywho = commentDAO.viewComment(CommentId, 1).getIntValue("commenter");
        temp.put("replyWho",Replywho);
        temp.put("thumbs", 0);
        int state;
        try{
            int ret = subCommentDAO.createSubComment(temp);
            if(ret==1){
                state = 1;
                System.out.println("yes");
            }
            else state = 2;
        }
        catch(RuntimeException e){
            state = 2;
        }
        JSONObject res=new JSONObject();
        res.put("state", state);
        return res;

    }

    public JSONObject modifySubComment(JSONObject inform,Integer SubCommentId){
        JSONObject temp = new JSONObject();
        Date date = new Date();
        temp.put("context", inform.get("Context"));
        temp.put("commnetDate", date);
        temp.put("replyWho", userDao.getUserbyName((String) inform.get("ReplyWho")).get("id"));
        int state;
        try{
            subCommentDAO.modifySubComment(temp, SubCommentId);
            state = 1;
        }
        catch(RuntimeException e){
            state = 2;
        }
        JSONObject res = new JSONObject();
        res.put("state",state);
        return res;
    }

    public JSONObject deleteSubComment(Integer SubCommentId){
        int state;
        try{
            subCommentDAO.deleteSubComment(SubCommentId);
            state = 1;
        }
        catch(RuntimeException e){
            state = 2;
        }
        JSONObject res = new JSONObject();
        res.put("state", state);
        return res;
    }


    public JSONObject viewSubCommentsbyComment(Integer CommentId,Integer UserId){
       List<JSONObject> list = subCommentDAO.viewSubcommentsByCommentId(CommentId, UserId);
       JSONObject res = new JSONObject();
        for (int i=0;i<list.size();i++){
            JSONObject tmp = list.get(i);
            JSONObject UserInfo = userDao.getUserbyId(tmp.getInteger("subcommenter"));
            tmp.put("name",UserInfo.getString("name"));
            tmp.put("image",UserInfo.getString("image"));
            res.put("subcomment"+Integer.toString(i), tmp);
        }
        return res;
    }

    //返回0表示已经点过赞了，返回1表示点赞成功，返回2表示超时
    public JSONObject thumb(Integer SubCommentId,Integer UserId){
//        JSONObject res=new JSONObject();
//        if (subCommentDAO.checkThumbbyUser(SubCommentId,UserId)==1){
//            res.put("state",0);
//            res.put("error","already thumbed");
//            return res;
//        }
//        else{
//        JSONObject inform=subCommentDAO.viewSubComment(SubCommentId,UserId);
//        int thumbs= (int) inform.get("thumbs");
//        thumbs = thumbs+1;
//        int state= subCommentDAO.thumb(SubCommentId,thumbs);
//        JSONObject temp=new JSONObject();
//        Date date=new Date();
//        temp.put("subcommentid",SubCommentId);
//        temp.put("thumberId",UserId);
//        temp.put("state",1);
//        temp.put("date",date);
//        subCommentDAO.createThumb(temp);
//        res.put("state",1);
//        return res;}
        int flag = subCommentDAO.isthumbed(SubCommentId, UserId);
        if (flag==1){
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "already thumbed");
            return res;
        }
        else if (flag==0){
            JSONObject inform = new JSONObject();
            inform.put("subcommentId", SubCommentId);
            inform.put("thumberId", UserId);
            Date date = new Date();
            inform.put("date", date);
            inform.put("state", 1);
            int state = subCommentDAO.createThumb(inform);
            JSONObject res = new JSONObject();
            res.put("state", state);
            return res;

        }
        else {
            JSONObject res = new JSONObject();
            res.put("state", flag);
            res.put("error", "Runtime error");
            return res;
        }
    }

    //state返回0表示本身就没点赞，返回1表示取消点赞成功，返回2表示超时
    public JSONObject unthumb(Integer SubCommentId,Integer UserId){
//        JSONObject res=new JSONObject();
//        if (subCommentDAO.checkThumbbyUser(SubCommentId,UserId)==2){
//            res.put("state",0);
//            res.put("error","haven't thumbed");
//            return res;
//        }
//        else{
//        JSONObject inform=subCommentDAO.viewSubComment(SubCommentId,UserId);
//        int thumbs= (int) inform.get("thumbs");
//        thumbs=thumbs-1;
//        int state= subCommentDAO.unthumb(SubCommentId,thumbs);
//        subCommentDAO.deleteThumb(SubCommentId,UserId);
//        res.put("state",1);
//        return res;}
        int flag = subCommentDAO.isthumbed(SubCommentId, UserId);
        if (flag==0){
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "already unthumbed");
            return res;
        }
        else if (flag==1){
            JSONObject inform = new JSONObject();
            inform.put("subcommentId", SubCommentId);
            inform.put("thumberId", UserId);
            Date date = new Date();
            inform.put("date", date);
            int state = subCommentDAO.deleteThumb(SubCommentId, UserId);
            JSONObject res = new JSONObject();
            res.put("state", state);
            return res;

        }
        else {
            JSONObject res = new JSONObject();
            res.put("state", flag);
            res.put("error", "Runtime error");
            return res;
        }
    }

}
