package com.example.club.dao;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HabbitDAOTest {

    @Autowired
    private HabbitDAO habbitDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end");
    }

    @Test
    public void createhabbit() {
        JSONObject inform = new JSONObject();
        inform.put("name", "圣斗士星");
        inform.put("info", "经典老番");
        Date date = new Date();
        inform.put("date", date);
        inform.put("creator", 9);
        inform.put("image", 10);
        habbitDAO.createhabbit(inform);
    }

    @Test
    public void createSubscribe(){
        habbitDAO.deleteSubscribe(1, 9);
        JSONObject inform = new JSONObject();
        inform.put("habbitid", 1);
        inform.put("fanid", 9);
        Date date = new Date();
        inform.put("date", date);
        inform.put("state", 1);
        habbitDAO.createSubscribe(inform);
    }

    @Test
    public void getHabbitbyName() {
        System.out.println(habbitDAO.getHabbitbyName("火影忍者"));
    }
}