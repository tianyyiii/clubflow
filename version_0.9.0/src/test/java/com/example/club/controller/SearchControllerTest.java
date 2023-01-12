package com.example.club.controller;

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
    }

    @Test
    public void searchforHabbit() {
    }

    @Test
    public void searchforPost() {
    }
}