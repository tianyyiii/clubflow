package com.example.club.service.Impl;

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
public class ClubServiceTest {

    @Autowired
    private ClubService clubservice;

    @Before
    public void before() throws Exception {
        System.out.println("开始测试方法");
    }

    @After
    public void after() throws Exception {
        System.out.println("单个方法测试结束");
    }

    @Test
    public void testCreateClub() {
        System.out.println("create");
        JSONObject par = new JSONObject();
        par.put("name", "guitar");
        par.put("inform", "love music");
        int UserId = 1;
        par.put("profile", "1");
        System.out.println(par);
        clubservice.createClub(par, UserId);
    }

    @Test
    public void testModifyClub() throws Exception {
        System.out.println("modify");
        JSONObject par = new JSONObject();
        par.put("name", "friend");
        par.put("inform", "happy");
        JSONObject res = clubservice.modifyClub(par, 4, 1);
        System.out.println(res);
    }

    @Test
    public void testViewClub() throws Exception {
        System.out.println("view");
        JSONObject res = clubservice.viewClub(8, 1);
        System.out.println(res);
    }

    @Test
    public void testViewClubbyAccount() throws Exception {
        System.out.println("viewclubbyaccount");
        JSONObject res = clubservice.viewClubbyAccount(2);
        System.out.println(res);
    }

    @Test
    public void testViewAnnouncement() throws Exception {
        System.out.println("viewannouncement");
        JSONObject res = clubservice.viewAnnouncement(2);
        System.out.println(res);
    }

    @Test
    public void testSubscribe() throws Exception {
        System.out.println("subscribe");
        JSONObject res = clubservice.subscribe(6, 3);
        System.out.println(res);
    }

    @Test
    public void testUnsubscribe() throws Exception {
        System.out.println("unsubscribe");
        clubservice.subscribe(6, 3);
        JSONObject res = clubservice.unsubscribe(6, 3);
        System.out.println(res);
    }

    @Test
    public void testCreateAnnouncement() throws Exception {
        System.out.println("createannouncement");
        JSONObject par = new JSONObject();
        par.put("context", "find more fun!");
        JSONObject res=clubservice.createAnnouncement(par, 4, 1);
        System.out.println(res);
    }

    @Test
    public void testModifyAnnouncement() throws Exception {
        System.out.println("modifyAnnouncement");
        JSONObject par = new JSONObject();
        par.put("context", "try again!");
        JSONObject res = clubservice.modifyAnnouncement(par, 6, 3);
        System.out.println(res);
    }

    @Test
    public void testDeleteAnnouncement() throws Exception {
        System.out.println("deleteannouncement");
        clubservice.deleteAnnouncement(6, 3);
    }
}