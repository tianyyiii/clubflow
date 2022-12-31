package com.example.club.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.club.utils.ImageUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/comment")
public class CommentController {


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
