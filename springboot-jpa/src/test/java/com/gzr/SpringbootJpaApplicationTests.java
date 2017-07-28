package com.gzr;

import com.gzr.p.User;
import com.gzr.p.UserRepository;
import com.gzr.s.User2;
import com.gzr.s.User2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private User2Repository user2Repository;

	@Test
	public void contextLoads() {
		logger.error("hahha");
		userRepository.save(new User("yuyu","112"));
		user2Repository.save(new User2("yuyu","112"));
	}

}
