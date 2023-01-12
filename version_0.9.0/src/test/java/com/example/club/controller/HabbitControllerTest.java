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
public class HabbitControllerTest {

    @Autowired
    private HabbitController habbitController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试HabbitController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试HabbitController单个方法");
    }

    @Test
    public void createHabbit() {
        System.out.println("createHabbit");
        JSONObject inform = new JSONObject();
        inform.put("UserId", 9);
        inform.put("name", "火影忍者");
        inform.put("inform", "喜欢火影忍者的偷摸大鸡看这里得吧呦！");
        inform.put("profile", "3");
        inform.put("announcement", "喜欢火影忍者的偷摸大鸡看这里得吧呦！");
        System.out.println(habbitController.CreateHabbit(inform));
    }

    @Test
    public void getCreatedHabbit() {
        System.out.println("getCreateHabbit");
        System.out.println(habbitController.GetCreatedHabbit(9));

    }

    @Test
    public void modifyHabbit() {
        System.out.println("modifyhabbit");
        JSONObject inform = new JSONObject();
        inform.put("HabbitId", 7);
        inform.put("UserId", 3);
        inform.put("name", "末日三问");
        inform.put("inform", "请问您要去斯卡布罗集市吗？");
        inform.put("image","2");
        System.out.println(habbitController.ModifyHabbit(inform));
    }

    @Test
    public void viewHabbitPage() {
        System.out.println("viewHabbitPage");
        System.out.println(habbitController.ViewHabbitPage(8, 9));
    }

    @Test
    public void viewHabbitbyAccount() {
        System.out.println("viewHabbitbyAccount");
        System.out.println(habbitController.ViewHabbitbyAccount(9));
    }

    @Test
    public void viewAllHabbits() {
        System.out.println("viewAllHabbits");
        System.out.println(habbitController.ViewAllHabbits());
    }

    @Test
    public void subscribe() {
        System.out.println("subscribe");
        JSONObject inform = new JSONObject();
        inform.put("HabbitId", 8);
        inform.put("UserId", 9);
        System.out.println(habbitController.subscribe(inform));
    }

    @Test
    public void viewClubFans() {
        System.out.println("viewClubFans");
        System.out.println(habbitController.ViewClubFans(8));
    }

    @Test
    public void unsubscribe() {
        System.out.println("unsubscribe");
        JSONObject inform = new JSONObject();
        inform.put("HabbitId", 8);
        inform.put("UserId", 9);
        System.out.println(habbitController.unsubscribe(inform));
    }
}