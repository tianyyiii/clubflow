package com.example.club.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.CommentService;
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
    public JSONObject createSubComment(@RequestBody JSONObject inform, Integer CommentId){
        return commentService.createComment(inform, CommentId);
    }

    @PostMapping("/modify")
    public JSONObject modifySubComment(@RequestBody JSONObject inform, Integer CommentId, Integer UserId){
        return commentService.modifyComment(inform, CommentId, UserId);

    }

    @DeleteMapping("/delete")
    public JSONObject deleteSubComment(Integer CommentId, Integer UserId){
        return commentService.deleteComment(CommentId, UserId);

    }

    //展示post下所有一级评论
    @GetMapping("/view")
    public JSONObject viewSubCommentbyComment(Integer PostId, Integer UserId){
        return commentService.viewCommentsByPost(PostId, UserId);

    }

    //点赞，具体注释在service
    @PostMapping("/thumb")
    public JSONObject thumb(Integer CommentId, Integer UserId){
        return commentService.thumb(CommentId, UserId);

    }

    //取消点赞，注释在service
    @PostMapping("/unthumb")
    public JSONObject unthumb(Integer CommentId, Integer UserId){
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
