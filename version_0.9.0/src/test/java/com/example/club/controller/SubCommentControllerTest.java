package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SubCommentControllerTest {

    @Autowired
    private SubCommentController subCommentController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试SubCommentController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试SubCommentController单个方法");
    }

    @Test
    public void createSubComment() {
        System.out.println("createSubComment");
        JSONObject inform = new JSONObject();
        inform.put("CommentId", 2);
        inform.put("UserId", 9);
        inform.put("Context", "世界第一");
        System.out.println(subCommentController.createSubComment(inform));
    }

    @Test
    public void modifySubComment() {
        System.out.println("modifySubComment");
        JSONObject inform = new JSONObject();
        inform.put("SubCommentId", 2);
        inform.put("Context", "C罗");
        inform.put("ReplyWho", "Say");
        System.out.println(subCommentController.modifySubComment(inform));

    }

    @Test
    public void deleteSubComment() {
        System.out.println("deleteSubComment");
        System.out.println(subCommentController.deleteSubComment(2));
    }

    @Test
    public void viewSubCommentbyComment() {
        System.out.println("viewSubCommentbyComment");
        System.out.println(subCommentController.viewSubCommentbyComment(1, 3));
    }

    @Test
    public void thumb() {
        System.out.println("thumb");
        JSONObject inform = new JSONObject();
        inform.put("SubCommentId",1);
        inform.put("UserId", 9);
        subCommentController.thumb(inform);

        subCommentController.thumb(inform);
    }

    @Test
    public void unthumb() {
        System.out.println("unthumb");
        JSONObject inform = new JSONObject();
        inform.put("SubCommentId", 1);
        inform.put("UserId", 9);
        subCommentController.unthumb(inform);

        subCommentController.unthumb(inform);

    }
}