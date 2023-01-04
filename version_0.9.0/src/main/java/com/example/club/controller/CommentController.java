package com.example.club.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.CommentService;
import com.example.club.service.Impl.SubCommentService;
import com.example.club.utils.ImageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@Api(tags="comment api")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;



    @PutMapping("/create")
    public JSONObject createComment(@RequestBody JSONObject inform){
        Integer PostId = inform.getInteger("PostId");
        // PostId UserId context
        // return: state 1--success , 2--error
        return commentService.createComment(inform, PostId);
    }

    @PostMapping("/modify")
    public JSONObject modifyComment(@RequestBody JSONObject inform){
        Integer CommentId = inform.getInteger("CommentId");
        Integer UserId = inform.getInteger("UserId");
        return commentService.modifyComment(inform, CommentId, UserId);

    }

    @DeleteMapping("/delete")
    public JSONObject deleteComment(Integer CommentId, Integer UserId){
        return commentService.deleteComment(CommentId, UserId);

    }

    //展示post下所有一级评论
    @GetMapping("/view")
    public JSONObject viewCommentbyPost(Integer PostId, Integer UserId){
        return commentService.viewCommentsByPost(PostId, UserId);

    }

    //点赞，具体注释在service
    @PostMapping("/thumb")
    public JSONObject thumb(@RequestBody JSONObject inform){
        Integer CommentId = inform.getInteger("CommentId");
        Integer UserId = inform.getInteger("UserId");
        //state返回0表示已经点过赞了，返回1表示点赞成功，返回2表示超时,返回3代表没有权限
        return commentService.thumb(CommentId, UserId);

    }
    //取消点赞，注释在service
    @PostMapping("/unthumb")
    public JSONObject unthumb(@RequestBody JSONObject inform){
        Integer CommentId = inform.getInteger("CommentId");
        Integer UserId = inform.getInteger("UserId");
        return commentService.unthumb(CommentId, UserId);

    }
    // 上传图片到后端的资源文件夹
    @PostMapping("/image")
    public JSONObject imageUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img"; // 图片保存目录
        JSONObject res=new JSONObject();
        File imageFolder = new File(folder);
        File f = new File(imageFolder, ImageUtil.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8080/file/" + f.getName();
            res.put("imgURL",imgURL);
            res.put("state",1); // success
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            res.put("state",0); // failed
            return res;
        }
    }
}
