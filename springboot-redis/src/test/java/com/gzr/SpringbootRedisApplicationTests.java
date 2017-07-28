package com.gzr;

import com.gzr.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	private static final Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String,User> redisTemplate;

	@Test
	public void contextLoads() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		logger.info(stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void test2(){
		// 保存对象
		User user = new User("超人", "20");
		redisTemplate.opsForValue().set(user.getName(), user);
		user = new User("蝙蝠侠", "30");
		redisTemplate.opsForValue().set(user.getName(), user);
		user = new User("蜘蛛侠", "40");
		redisTemplate.opsForValue().set(user.getName(), user);
		Assert.assertEquals("20", redisTemplate.opsForValue().get("超人").getPassword());
		Assert.assertEquals("30", redisTemplate.opsForValue().get("蝙蝠侠").getPassword());
		Assert.assertEquals("40", redisTemplate.opsForValue().get("蜘蛛侠").getPassword());
	}
}

