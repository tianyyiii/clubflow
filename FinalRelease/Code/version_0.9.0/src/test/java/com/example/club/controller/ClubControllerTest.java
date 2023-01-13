package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClubControllerTest {

    @Autowired
    private ClubController clubController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试ClubController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试ClubController单个方法");
    }

    @Test
    public void createClub() {
        System.out.println("create");
        JSONObject inform = new JSONObject();
        inform.put("name", "围棋社");
        inform.put("inform", "围棋同好");
        inform.put("profile", "/workspace/img/nf8ipc.jpg");
        inform.put("UserId", 9);
        clubController.CreateClub(inform);
    }

    @Test
    public void getCreatedClub() {
        System.out.println("getCreateClub");
        System.out.println(clubController.GetCreatedClub(9));
    }

    @Test
    public void modifyClub() {
        System.out.println("modify");
        JSONObject inform = new JSONObject();
        inform.put("name", "ACG集结地");
        inform.put("inform", "发现每一种兴趣");
        inform.put("image", "/workspace/img/index_img_4.png");
        inform.put("ClubId", 8);
        inform.put("UserId", 9);
        clubController.ModifyClub(inform);
    }

    @Test
    public void viewClubPage() {
        System.out.println("viewClubPage");
        System.out.println(clubController.ViewClubPage(8, 9));
    }

    @Test
    public void viewClubbyAccount() {
        System.out.println("viewClubByAccount");
        System.out.println(clubController.ViewClubbyAccount(9));
    }

    @Test
    public void viewAllClubs() {
        System.out.println("viewAllClub");
        System.out.println(clubController.ViewAllClubs());
    }

    @Test
    public void subscribe() {
        System.out.println("subscribe");
        JSONObject inform = new JSONObject();
        inform.put("ClubIb", 8);
        inform.put("UserId", 9);
        clubController.Subscribe(inform);
    }

    @Test
    public void viewClubFans() {
        System.out.println("viewClubFans");
        System.out.println(clubController.ViewClubFans(8));
    }

    @Test
    public void viewAnnouncement() {
        System.out.println("viewAnnouncement");
        System.out.println(clubController.ViewAnnouncement(9));
    }

    @Test
    public void createAnnouncement() {
        System.out.println("createAnnouncement");
        JSONObject inform = new JSONObject();
        inform.put("ClubId", 8);
        inform.put("UserId", 9);
        inform.put("context", "推荐《强风吹拂》");
        System.out.println(clubController.CreateAnnouncement(inform));
    }

    @Test
    public void modifyAnnouncement() {
        System.out.println("modifyAnnouncement");
        JSONObject inform = new JSONObject();
        inform.put("ClubId", 8);
        inform.put("UserId", 9);
        inform.put("context", "推荐《钢之炼金术师》");
        System.out.println(clubController.ModifyAnnouncement(inform));
    }

    @Test
    public void deleteAnnouncement() {
        System.out.println("deleteAnnouncement");
        clubController.DeleteAnnouncement(8, 9);
    }



    @Test
    public void unsubscribe() {
        System.out.println("unsubscribe");
        JSONObject inform = new JSONObject();
        inform.put("ClubIb", 8);
        inform.put("UserId", 9);
        System.out.println(clubController.Unsubscribe(inform));
    }
}