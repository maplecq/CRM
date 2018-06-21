package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.entity.Users;
@Component
@Mapper
public interface UsersMapper {
	public List<Users> getAll();

}
