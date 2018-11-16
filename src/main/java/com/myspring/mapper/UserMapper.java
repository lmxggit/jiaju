package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myspring.entity.UserEntity;

public interface UserMapper {
	List<UserEntity> findUsers(@Param("name") String name);
}
