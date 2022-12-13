package com.example.club.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.PostService;
import com.example.club.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private ImageUtil imageUtil;
    @PutMapping("/create")
    public JSONObject createPost(JSONObject inform,int UserId){

/*        JSONObject state=new JSONObject();
        inform.put("state",1);
        inform.put("PostId",10);
        return inform;*/
        return postService.createPost(inform,UserId);

    }
    @PostMapping("/modify")
    public JSONObject modifyPost(JSONObject inform,int PostId,int UserId){
        JSONObject state=new JSONObject();
        inform.put("state",1);
        return inform;
/*        return postService.modifyPost(inform, PostId, UserId);*/
    }
    @GetMapping("/{PostId}")
    public JSONObject viewPost(@PathVariable int PostId,int UserId){
        JSONObject post=new JSONObject();
        post.put("title","流动社团");
        post.put("context","这是关于流动社团的介绍");
        post.put("thumbs-up num",10);
        post.put("comments num",25);
        post.put("club name","800号电影社");
        System.out.println("aple");
        post.put("club profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
        post.put("image", imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
        post.put("club id",800);
        return post;
/*        return postService.viewPost(PostId, UserId);*/
    }
    @GetMapping("/view_by_user")
    public JSONObject viewPostbyUser(int UserId){
/*        JSONObject post_list=new JSONObject();
        for (int i=1;i<3;i++)
        {JSONObject post=new JSONObject();
            post.put("title","流动社团");
            post.put("context","这是关于流动社团的介绍");
            post.put("thumbs-up num",10);
            post.put("comments num",25);
            post.put("club name","800号电影社");
            System.out.println("aple");
            post.put("club profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
            post.put("image", imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
            post.put("club id",800);
            post_list.put("post"+Integer.toString(i),post);



        }*/
/*        return post_list;*/
        System.out.println("aple");
        return postService.viewPostbyUser(UserId);
    }
    @GetMapping("view_by_club")
    public JSONObject viewPostbyCLub(int ClubId,int UserId){
/*        JSONObject post_list=new JSONObject();
        for (int i=1;i<3;i++)
        {JSONObject post=new JSONObject();
            post.put("title","流动社团");
            post.put("context","这是关于流动社团的介绍");
            post.put("thumbs-up num",10);
            post.put("comments num",25);
            post.put("club name","800号电影社");
            System.out.println("aple");
            post.put("club profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
            post.put("image", imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
            post.put("club id",800);
            post_list.put("post"+Integer.toString(i),post);



        }
        return post_list;*/
        return postService.viewPostbyClub(ClubId, UserId);

    }
}

