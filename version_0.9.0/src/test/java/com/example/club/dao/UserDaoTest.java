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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end");
    }

    @Test
    public void createuser() {
        userDao.deleteuser(13);
        JSONObject inform = new JSONObject();
        inform.put("name", 12);
        inform.put("passwd", "12345");
        inform.put("role", 1);
        inform.put("image", "7");
        userDao.createuser(inform);
    }

    @Test
    public void login(){
        userDao.login("Say", "shenaiyao");
        userDao.login("123345643", "r4387926");
        userDao.login("Say", "fjkalhfiud");
    }
}