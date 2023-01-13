package com.example.club.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.jar.JarEntry;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClubDAOTest {

    @Autowired
    private ClubDAO clubDAO;

    @Before
    public void setUp() throws Exception {
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end");
    }

    @Test
    public void createclub() {
        JSONObject inform = new JSONObject();
        inform.put("name", "123");
        inform.put("info", "welcome");
        Date date = new Date();
        inform.put("date", date);
        inform.put("creator", 9);
        inform.put("image", "4");
        clubDAO.createclub(inform);
    }

    @Test
    public void getClubbyCreatorId() {
        int UserId = 10;
        clubDAO.getClubbyCreatorId(UserId);
    }

    @Test
    public void getClubbyName() {
        clubDAO.getClubbyName("ACG");
        clubDAO.getClubbyName("123");
        clubDAO.getClubbyName(null);
    }

    @Test
    public void listmyclubs() {
        System.out.println(clubDAO.listmyclubs(9));
        clubDAO.listmyclubs(0);
    }

    @Test
    public void listclubfans() {
        clubDAO.listclubfans(0);
    }

    @Test
    public void viewAnnouncementbyClubId() {
        clubDAO.viewAnnouncementbyClubId(9);
        clubDAO.viewAnnouncementbyClubId(0);
    }

    @Test
    public void editAnnouncementbyClubId() {
        clubDAO.editAnnouncementbyClubId("Welcome!!!", 11);
        clubDAO.editAnnouncementbyClubId("Welcome!!!", 0);
    }

    @Test
    public void subscribeAdd() {
        clubDAO.subscribeAdd(0, 0);
    }

    @Test
    public void subscribeMinus() {
        clubDAO.subscribeMinus(0, 9);
        clubDAO.subscribeMinus(9, 9);
    }

    @Test
    public void createSubscribe() {
    }

    @Test
    public void deleteSubscribe() {
        clubDAO.deleteSubscribe(6, 3);
        clubDAO.deleteSubscribe(0, 9);
    }

    @Test
    public void checkSubscribebyUser() {
        clubDAO.checkSubscribebyUser(1, 3);
        clubDAO.checkSubscribebyUser(0, 9);
    }
}