package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentControllerTest {

    @Autowired
    private CommentController commentController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试CommentController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试CommentController单个方法");
    }

    @Test
    public void createComment() {
        System.out.println("createComment");
        JSONObject inform = new JSONObject();
        inform.put("PostId", 4);
        inform.put("UserId", 9);
        inform.put("context", "恋恋世界第一");
        System.out.println(commentController.createComment(inform));
    }

    @Test
    public void modifyComment() {
        System.out.println("modifyComment");
        JSONObject inform = new JSONObject();
    }

    @Test
    public void deleteComment() {
    }

    @Test
    public void viewCommentbyPost() {
    }

    @Test
    public void thumb() {
    }

    @Test
    public void unthumb() {
    }

    @Test
    public void imageUpload() {
    }
}