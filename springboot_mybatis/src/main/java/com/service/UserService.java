package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entity.Users;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List getAll(){
		  return jdbcTemplate.queryForList("select * from users");
	}

}
