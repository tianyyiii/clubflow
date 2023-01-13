package com.example.club.dao;

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
public class SubCommentDAOTest {

    @Autowired
    private SubCommentDAO subCommentDAO;

    @Before
    public void setUp() throws Exception {
        System.out.println("start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("end");
    }

    @Test
    public void thumb() {
        subCommentDAO.thumb(1, 0);

    }

    @Test
    public void unthumb() {
        subCommentDAO.unthumb(1,0);
    }

}