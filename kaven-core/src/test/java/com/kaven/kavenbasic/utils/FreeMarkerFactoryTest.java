package com.kaven.kavenbasic.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaven.kavencore.domain.User;
import com.kaven.kavencore.utils.FreeMarkerFactory;

/**
 * FreeMarkerFactoryTest
 * @desc: kaven-core
 * @author: wangwei
 * @createTime: 2017年6月26日 下午6:55:23
 * @history:
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FreeMarkerFactoryTest {

	@Test
	public void testCreateHTML(){
		
		String ftlPath = "e:/Kaven/test.ftl";
		String filePath = "e:/Kaven/template.html";
		Map<String,Object> data = new HashMap<String,Object>();
		User user = new User();
		user.setId(1l);
		user.setName("www");
		
		data.put("user", user);
		
		try {
			FreeMarkerFactory.createHTML(ftlPath, filePath, data);
		} catch (IOException e) {
			
			e.printStackTrace();
				
		}
	}
}

	