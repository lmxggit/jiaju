package com.myspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.entity.UserEntity;
import com.myspring.mapper.UserMapper;
import com.myspring.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserEntity> findByName(String name) {
		return userMapper.findUsers(name);
	}
}
