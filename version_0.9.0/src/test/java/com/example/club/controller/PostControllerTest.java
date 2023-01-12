package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.jar.JarEntry;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostControllerTest {

    @Autowired
    private PostController postController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试PostController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试PostController单个方法");
    }

    @Test
    public void createPost() {
        System.out.println("createPost");
        JSONObject inform = new JSONObject();
        inform.put("UserId", 9);
        inform.put("title", "2023年度招新");
        inform.put("context", "喜欢二次元的小伙伴欢迎加入漫研社！和同好们讨论主旨，角色，分镜，作画，配乐，诚邀各位到来!");
        inform.put("image", "workspace/img/2tt6uk.jpg");
        inform.put("clubId", 8);
        System.out.println(postController.CreatePost(inform));
    }

    @Test
    public void createPostforHabbit() {
        System.out.println("createPostforHabbit");
        JSONObject inform = new JSONObject();
        inform.put("UserId", 9);
        inform.put("title", "火影忍者角色人气榜单投票");
        inform.put("context", "选择火影中最喜欢的角色");
        inform.put("image", "3");
        inform.put("clubId", 8);
        System.out.println(postController.CreatePostforHabbit(inform));
    }

    @Test
    public void modifyPost() {
        System.out.println("modifyPost");
        JSONObject inform = new JSONObject();
        inform.put("title", "火影忍者角色人气榜单投票");
        inform.put("context", "选择火影中最喜欢的角色");
        System.out.println(postController.ModifyPost(inform, 6, 9));

    }

    @Test
    public void viewPostInUser() {
        System.out.println("viewPostInUser");
        System.out.println(postController.ViewPostInUser(4, 8));
    }

    @Test
    public void viewPosts() {
        System.out.println("virePosts");
        System.out.println(postController.ViewPosts());
    }

    @Test
    public void viewPostsbyUser() {
        System.out.println("viewPostsbyUser");
        System.out.println(postController.ViewPostsbyUser(8));
    }

    @Test
    public void viewPostsSubscribed() {
        System.out.println("viewPostsSubscribed");
        System.out.println(postController.ViewPostsSubscribed(8));
    }

    @Test
    public void viewPostbyCLub() {
        System.out.println("viewPostbyClub");
        System.out.println(postController.ViewPostbyCLub(1, 8));
    }

    @Test
    public void viewPostbyHabbit() {
        System.out.println("viewPostbyHabbit");
        System.out.println(postController.ViewPostbyHabbit(1,1));
    }

    @Test
    public void changeThumbState() {
        System.out.println("changeThumbeState");
        System.out.println(postController.ChangeThumbState(6, 9));
    }
}