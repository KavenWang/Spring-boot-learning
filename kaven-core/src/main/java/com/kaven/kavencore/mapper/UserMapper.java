package com.kaven.kavencore.mapper;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kaven.kavencore.domain.User;

@Component
public interface UserMapper {

	public void saveUser(User user);
}

	