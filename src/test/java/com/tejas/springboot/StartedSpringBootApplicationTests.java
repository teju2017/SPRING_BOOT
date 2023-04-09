package com.tejas.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tejas.springboot.services.ReadAccessFile;

@SpringBootTest
class StartedSpringBootApplicationTests {
	
	@Autowired
	public ReadAccessFile readobj;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void userNameTest()
	{
		readobj.getUserDetails("avu");
	}

}
