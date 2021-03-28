package com.fjk;

import com.fjk.produce.RabbitProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqExampleApplicationTests {

	@Resource
	private RabbitProducer rabbitProducer;


	@Test
	public void contextLoads() {
		rabbitProducer.sendMessage("directExChange-123");
	}

}
