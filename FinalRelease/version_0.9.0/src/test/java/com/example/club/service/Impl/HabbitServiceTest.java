package com.example.club.service.Impl;

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
public class HabbitServiceTest {

    @Autowired
    private HabbitService habbitService;

    @Before
    public void setUp() throws Exception {
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end");
    }

    @Test
    public void viewHabbit() {
        habbitService.viewHabbit(1, 2);
        habbitService.viewHabbit(1, 3);
    }
}