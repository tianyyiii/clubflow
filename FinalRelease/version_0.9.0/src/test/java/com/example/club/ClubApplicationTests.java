package com.example.club;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ClubApplicationTests {

	@Autowired
	private ClubApplication clubApplication;

	@Test
	public void contextLoads() {
		System.out.println("contextLoads");
		String args = "测试输出";
//		ClubApplication.main(new String[]{args});
	}

}
