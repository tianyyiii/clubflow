package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.CommentDAO;
import com.example.club.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private UserDao userDAO;

    public JSONObject createComment(JSONObject inform, int PostId){
        JSONObject tmp = new JSONObject();
        tmp.put("commenter", inform.getIntValue("UserId"));
        tmp.put("post", PostId);
        tmp.put("context", inform.getString("context"));
        Date date = new Date();
        tmp.put("commentDate", date);
        tmp.put("thumbs",0);
        int flag = commentDAO.createcomment(tmp);
        JSONObject res = new JSONObject();
        res.put("state", flag);
        return res;
    }

    //返回0代表权限不够，返回1代表成功修改，返回2代表超时
    public JSONObject modifyComment(JSONObject inform, int CommentId, int UserId){
        int power = commentDAO.Check(CommentId, UserId);
        if(power==1){
            Date date=new Date();
            inform.put("commentDate",date);
            int flag = commentDAO.modifyComment(inform, CommentId);
            JSONObject res = commentDAO.viewComment(CommentId, UserId);
            res.put("state", flag);
            return res;
        }
        else{
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "has no power to modify");
            return res;
        }
    }

    //返回0代表权限不够，返回1代表成功删除，返回2代表超时
    public JSONObject deleteComment(int CommentId, int UserId){
        int power = commentDAO.Check(CommentId, UserId);
        if(power==1){
            int flag = commentDAO.deleteComment(CommentId);
            JSONObject res = new JSONObject();
            res.put("state", flag);
            return res;
        }
        else{
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "has no power to delete");
            return res;
        }
    }

    public JSONObject viewCommentsByPost(int PostId, int UserId){
        try{
            JSONObject res = new JSONObject();
            List<JSONObject> list = commentDAO.viewCommentsByPostId(PostId, UserId);
            for(int i=0;i<list.size();++i){
                JSONObject tmp = list.get(i);
                JSONObject UserInfo = userDAO.getUserbyId(tmp.getInteger("commenter"));
                tmp.put("name",UserInfo.getString("name"));
                tmp.put("image",UserInfo.getString("image"));
                res.put("comment"+Integer.toString(i), tmp);
            }
            res.put("state", 1);
            return res;

        }catch (RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            res.put("error", "Runtime error");
            return res;
        }
    }

    //state返回0表示已经点过赞了，返回1表示点赞成功，返回2表示超时,返回3代表没有权限
    public JSONObject thumb(int CommentId, int UserId){
        int power=1;
        if (power==0){
            JSONObject res = new JSONObject();
            res.put("state", 3);
            res.put("error", "no power");
            return res;
        }
        int flag = commentDAO.isthumbed(CommentId, UserId);
        if (flag==1){
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "already thumbed");
            return res;
        }
        else if (flag==0){
            int state = commentDAO.thumb(CommentId, UserId);
            JSONObject res = commentDAO.viewComment(CommentId, UserId);
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

    //state返回0表示本来就没点赞，返回1表示取消点赞成功，返回2表示超时,返回3代表没有权限
    public JSONObject unthumb(int CommentId, int UserId){
        int power = 1;
        if (power==0){
            JSONObject res = new JSONObject();
            res.put("state", 3);
            res.put("error", "no power");
            return res;
        }
        int flag = commentDAO.isthumbed(CommentId, UserId);
        if (flag==0){
            JSONObject res = new JSONObject();
            res.put("state", 0);
            res.put("error", "already unthumbed");
            return res;
        }
        else if (flag==1){
            int state = commentDAO.unthumb(CommentId, UserId);
            JSONObject res = commentDAO.viewComment(CommentId, UserId);
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
