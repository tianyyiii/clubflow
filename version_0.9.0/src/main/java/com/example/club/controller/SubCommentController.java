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
    /*checked*/
    @PutMapping("/create")
    public JSONObject createSubComment(@RequestBody JSONObject inform,Integer CommentId){
        return subCommentService.createSubComment(inform,CommentId);
    }
/*checked*/
    @PostMapping("/modify")
    public JSONObject modifySubComment(@RequestBody JSONObject inform,Integer SubCommentId){
        return subCommentService.modifySubComment(inform,SubCommentId);

    }
/*checked*/
    @DeleteMapping("/delete")
    public JSONObject deleteSubComment(Integer SubCommentId){
        return subCommentService.deleteSubComment(SubCommentId);

    }
/*checked*/
    @GetMapping("/view")
    public JSONObject viewSubCommentbyComment(Integer CommentId,Integer UserId){
        return subCommentService.viewSubCommentbyComment(CommentId,UserId);

    }
/*checked*/
    @PostMapping("/thumb")
    public JSONObject thumb(Integer SubCommentId,Integer UserId){
        return subCommentService.thumb(SubCommentId,UserId);

    }
/*checked*/
    @PostMapping("/unthumb")
    public JSONObject unthumb(Integer SubCommentId,Integer UserId){
        return subCommentService.unthumb(SubCommentId,UserId);

    }


}
