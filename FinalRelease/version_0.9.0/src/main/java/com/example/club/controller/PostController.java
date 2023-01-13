package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.IPostService;
import com.example.club.utils.ImageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags="post api")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private ImageUtil imageUtil;
/*checked*/
    @PutMapping("/create")
    public JSONObject CreatePost(@RequestBody JSONObject inform){
        int UserId = inform.getIntValue("UserId");
        return postService.createPost(inform, UserId,0);
        //state=0, 目前club下已经存在一个同名post; state=1, 创建post成功；state=2, 操作超时
    }

    @PutMapping("/create_for_habbit")
    public JSONObject CreatePostforHabbit(@RequestBody JSONObject inform){
        int UserId = inform.getIntValue("UserId");
        return postService.createPost(inform,UserId,1);
    }
/*checked*/
    @PostMapping("/modify")
    public JSONObject ModifyPost(@RequestBody JSONObject inform,int PostId,int UserId){
        //state = 1, 成功修改post；state = 0, 不合规范，修改失败；state = 2, 修改超时
        return postService.modifyPost(inform, PostId, UserId);
    }
/*checked*/
    //从user进入post
    @GetMapping("/{PostId}")
    public JSONObject ViewPostInUser(@PathVariable int PostId,int UserId){

        //state=1, 正确访问post; state=2, 访问超时
        return postService.viewPostInUser(PostId, UserId);
    }

    /*checked*/
    //在首页获取全部posts
    @GetMapping("/view_list")
    public JSONObject ViewPosts(){

        //state=1, 正确访问post; state=2, 访问超时
        return postService.viewPostList();
    }

/*checked*/
    // 查看用户创建的posts
    @GetMapping("/view_by_user")
    public JSONObject ViewPostsbyUser(int UserId){
        //state=1表示访问成功，形式是{“state”:1, "post1":JSONObject, "post2":JSONObject, ..., }
        //state=2表示访问超时
        System.out.println("aple");
        return postService.viewPostsbyUser(UserId);
    }

    // 查看用户关注社团的posts
    @GetMapping("/view_user_subscribed")
    public JSONObject ViewPostsSubscribed(int UserId){
        return postService.viewPostsSubscribed(UserId);
    }

/*checked*/
    @GetMapping("view_by_club")
    public JSONObject ViewPostbyCLub(int ClubId,int UserId){
        //state=1表示访问成功，形式是{“state”:1, "post1":JSONObject, "post2":JSONObject, ..., }
        //state=2表示访问超时
        return postService.viewPostsbyClub(ClubId, UserId);
    }

    @GetMapping("/view_by_habbit")
    public JSONObject ViewPostbyHabbit(int HabbitId,int UserId){
        return postService.viewPostsbyHabbit(HabbitId,UserId);
    }
/*checked*/
    @GetMapping("change_thumb_state")
    public JSONObject ChangeThumbState(int PostId, int UserId){
        //state=1,修改成功，返回新界面；state=2，修改超时
        return postService.ThumbOrUnthumb(PostId, UserId);
    }
}

