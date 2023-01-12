package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.Jar;
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
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试UserController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试UserController单个方法");
    }

    @Test
    public void register() {
        System.out.println("register");
        JSONObject inform = new JSONObject();
        inform.put("name", "Say");
        inform.put("password", "shenaiyao");
        inform.put("role", 1);
        inform.put("profile", "http://localhost:8080/file/index_img_3.png");
        System.out.println(userController.Register(inform));
    }

    @Test
    public void modifyUser() {
        System.out.println("modifyUser");
        JSONObject inform = new JSONObject();
        inform.put("name", "Say");
        inform.put("password", "shenaiyao");
        inform.put("profile", "http://localhost:8080/file/index_img_3.png");
        System.out.println(userController.ModifyUser(inform, 9));
    }

    @Test
    public void deleteUser() {
        System.out.println("deleteUser");
        System.out.println(userController.DeleteUser(2,9));
    }

    @Test
    public void viewUser() {
        System.out.println("viewUser");
        System.out.println(userController.ViewUser(9, 9));
    }

    @Test
    public void checkUser() {
        System.out.println("checkUser");
        System.out.println(userController.CheckUser("Say", "shenaiyao"));
    }
}