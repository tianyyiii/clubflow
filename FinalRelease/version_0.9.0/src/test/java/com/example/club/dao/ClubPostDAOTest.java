package com.example.club.dao;

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
public class ClubPostDAOTest {

    @Autowired
    private ClubPostDAO clubPostDAO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPostbyTitleANDClub() {
        System.out.println(clubPostDAO.getPostbyTitleANDClub(1, "Guitar"));
        System.out.println(clubPostDAO.getPostbyTitleANDClub(1, "Play Guitar"));
    }

    @Test
    public void listClubPosts() {
        System.out.println(clubPostDAO.listClubPosts(1, 0));
        System.out.println(clubPostDAO.listClubPosts(1, 1));
        System.out.println(clubPostDAO.listClubPosts(1, 2));
        System.out.println(clubPostDAO.listClubPosts(2, 1));
        System.out.println(clubPostDAO.listClubPosts(3, 1));
        System.out.println(clubPostDAO.listClubPosts(3, 2));
    }

    @Test
    public void thumbedOrNot() {
        System.out.println(clubPostDAO.thumbedOrNot(1, 1));
        System.out.println(clubPostDAO.thumbedOrNot(2, 1));
    }

    @Test
    public void changethumbpost() {
        System.out.println(clubPostDAO.changethumbpost(2, 9));
        System.out.println(clubPostDAO.changethumbpost(1, 1));
        System.out.println(clubPostDAO.changethumbpost(3,1));
    }

}