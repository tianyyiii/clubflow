package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchControllerTest {

    @Autowired
    private SearchController searchController;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试SearchController单个方法");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试SearchController单个方法");
    }

    @Test
    public void searchforClub() {
        System.out.println("searchforClub");
        JSONObject inform = new JSONObject();
        inform.put("key", "A");
        System.out.println(searchController.SearchforClub(inform));
    }

    @Test
    public void searchforHabbit() {
        System.out.println("searchforHabbit");
        JSONObject inform = new JSONObject();
        inform.put("key", "火影");
        System.out.println(searchController.SearchforHabbit(inform));

    }

    @Test
    public void searchforPost() {
        System.out.println("searchforPost");
        JSONObject inform = new JSONObject();
        inform.put("key", "恋");
        System.out.println(searchController.SearchforPost(inform));
    }
}