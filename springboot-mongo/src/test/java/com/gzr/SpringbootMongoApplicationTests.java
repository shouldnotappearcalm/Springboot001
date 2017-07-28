package com.gzr;

import com.gzr.domain.User;
import com.gzr.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {

	private static final Logger logger= LoggerFactory.getLogger(SpringbootMongoApplication.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		// 创建三个User，并验证User总数
		userRepository.save(new User(1L, "didi", 30));
		userRepository.save(new User(2L, "mama", 40));
		userRepository.save(new User(3L, "kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());
		List<User> list=userRepository.findAll();
		for(User user:list){
			logger.info(user.toString());
		}
		logger.info(SpringbootMongoApplicationTests.class+"");
		logger.info(this.getClass()+"");
		/*// 删除一个User，再验证User总数
		User u = userRepository.findOne(1L);
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());
		// 删除一个User，再验证User总数
		u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());*/
	}
}



