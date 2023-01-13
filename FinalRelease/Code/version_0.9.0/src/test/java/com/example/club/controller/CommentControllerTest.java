package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.entity.ContentType;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

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
        inform.put("context", "恋恋世界第一!");
        System.out.println(commentController.createComment(inform));
    }

    @Test
    public void modifyComment() {
        System.out.println("modifyComment");
        JSONObject inform = new JSONObject();
        inform.put("CommentId", 2);
        inform.put("UserId", 9);
        inform.put("context", "恋恋世界第一可爱！");
        System.out.println(commentController.modifyComment(inform));

        JSONObject inform2 = new JSONObject();
        inform2.put("CommentId", 2);
        inform2.put("UserId", 1);
        inform2.put("context", "恋恋世界第一可爱！");
        System.out.println(commentController.modifyComment(inform2));
    }

    @Test
    public void deleteComment() {
        System.out.println("deleteComment");
        System.out.println(commentController.deleteComment(2,9));
        System.out.println(commentController.deleteComment(2,1));
    }

    @Test
    public void viewCommentbyPost() {
        System.out.println("viewCommentbyPost");
        System.out.println(commentController.viewCommentbyPost(4, 9));
        System.out.println(commentController.viewCommentbyPost(11, 0));
    }

    @Test
    public void thumb() {
        System.out.println("thumb");
        JSONObject inform = new JSONObject();
        inform.put("CommentId", 2);
        inform.put("UserId", 9);
        System.out.println(commentController.thumb(inform));

        JSONObject inform2 = new JSONObject();
        inform2.put("CommentId", 2);
        inform2.put("UserId", 9);
        System.out.println(commentController.thumb(inform2));
    }

    @Test
    public void unthumb() {
        System.out.println("unthumb");
        JSONObject inform = new JSONObject();
        inform.put("CommentId", 2);
        inform.put("UserId", 9);
        System.out.println(commentController.unthumb(inform));

        JSONObject inform1 = new JSONObject();
        inform1.put("CommentId", 1);
        inform1.put("UserId", 9);
        System.out.println(commentController.unthumb(inform1));

        JSONObject inform2 = new JSONObject();
        inform2.put("CommentId", 2);
        inform2.put("UserId", 9);
        System.out.println(commentController.thumb(inform));
    }

    @Test
    public void imageUpload() throws Exception {
        System.out.println("imageUpload");
        File file = new File("C:\\Classes\\Junior_1\\Software Engineering\\Workspace3\\clubflow\\workspace\\img\\2tt6uk.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), ContentType.IMAGE_PNG.toString(), fileInputStream);
        commentController.imageUpload(multipartFile);
    }
}