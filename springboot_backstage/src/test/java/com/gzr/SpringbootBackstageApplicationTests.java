package com.gzr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBackstageApplicationTests {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@Test
	public void contextLoads() {
		String s1=bCryptPasswordEncoder.encode("Aa11223344");
		String s2=bCryptPasswordEncoder.encode("Aa11223344");
		logger.info(s1.equals(s2)+"");
		logger.info("tttt:"+bCryptPasswordEncoder.matches("Aa11223344",s1));
		logger.info("tttt2:"+bCryptPasswordEncoder.matches("Aa11223344",s2));
		logger.info("密码:"+bCryptPasswordEncoder.encode("Aa11223344"));
	}

}
