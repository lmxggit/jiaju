package com.myspring.service;

import java.util.List;

import com.myspring.entity.UserEntity;

public interface IUserService {
	List<UserEntity> findByName(String name);
}
