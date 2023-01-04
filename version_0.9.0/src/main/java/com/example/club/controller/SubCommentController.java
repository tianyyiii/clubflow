package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.SubCommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags="subcomment api")
@RestController
@RequestMapping("/subcomment")
public class SubCommentController {
    @Autowired
    private SubCommentService subCommentService;
    @PutMapping("/create")
    public JSONObject createSubComment(@RequestBody JSONObject inform){
        Integer CommentId = inform.getInteger("CommentId");
        // CommentId UserId Context
        return subCommentService.createSubComment(inform, CommentId);
    }
    @PostMapping("/modify")
    public JSONObject modifySubComment(@RequestBody JSONObject inform){
        Integer SubCommentId = inform.getInteger("SubCommentId");
        return subCommentService.modifySubComment(inform,SubCommentId);

    }
    @DeleteMapping("/delete")
    public JSONObject deleteSubComment(Integer SubCommentId){
        return subCommentService.deleteSubComment(SubCommentId);

    }
    //展示comment下所有二级评论
    @GetMapping("/view")
    public JSONObject viewSubCommentbyComment(Integer CommentId,Integer UserId){
        return subCommentService.viewSubCommentsbyComment(CommentId,UserId);

    }
    //注释在service
    @PostMapping("/thumb")
    public JSONObject thumb(@RequestBody JSONObject inform){
        Integer SubCommentId = inform.getInteger("SubCommentId");
        Integer UserId = inform.getInteger("UserId");
        //返回0表示已经点过赞了，返回1表示点赞成功，返回2表示超时
        return subCommentService.thumb(SubCommentId,UserId);

    }
    //注释在service
    @PostMapping("/unthumb")
    public JSONObject unthumb(@RequestBody JSONObject inform){
        Integer SubCommentId = inform.getInteger("SubCommentId");
        Integer UserId = inform.getInteger("UserId");
        //state返回0表示本身就没点赞，返回1表示取消点赞成功，返回2表示超时
        return subCommentService.unthumb(SubCommentId,UserId);

    }


}
