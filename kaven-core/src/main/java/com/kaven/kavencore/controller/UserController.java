
package com.kaven.kavencore.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaven.kavencore.domain.User;
import com.kaven.kavencore.mapper.UserMapper;
import com.kaven.kavencore.utils.FreeMarkerFactory;

@RestController
@RequestMapping("/api")
public class UserController {

	@Resource
	private UserMapper userMapper;
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void testCreateHTML(){
		String ftlPath = "E:\\Kaven\\test.ftl";
		String filePath = "E:\\Kaven\\template.html";
		Map<String,Object> data = new HashMap<String,Object>();
		User user = new User();
		user.setId(1l);
		user.setName("www");
		user.setPassword("0000");
		user.setAge(22);
		data.put("user", user);
		
		try {
			FreeMarkerFactory.createHTML(ftlPath, filePath, data);
		} catch (IOException e) {
			
			e.printStackTrace();
				
		}
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	@Transactional
	public void saveUser(){
		User user = new User();
		user.setId(6l);
		user.setName("www");
		user.setPassword("0000");
		user.setAge(22);
		userMapper.saveUser(user);
		User user1 = new User();
		user1.setId(7l);
		user1.setName("Spring Boot中使用Swagger2构建RESTful APIsSpring Boot中使用Swagger2构建RESTful APIs");
		user1.setPassword("0000");
		user1.setAge(22);
		userMapper.saveUser(user1);
	}
		
}

	