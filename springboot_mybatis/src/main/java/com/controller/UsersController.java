package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UsersMapper;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.service.UserService;

@Controller
public class UsersController {
	@Autowired
	private UsersMapper usersmapper;

	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAll(Integer page) {
		// 当前页码
		if (page == null) {
			page = 1;
		}
		// 每页显示条数
		int pageSize = 2;
		Map<String, Object> map = new HashMap<String, Object>();
		// pagehelper 需要两个参数 page-->当前页码 pageSize-->每页显示条数
		PageHelper.startPage(page, pageSize);
		List<Users> list = usersmapper.getAll();
		map.put("list", list);
		return map;
	}

	// @Autowired
	// private UserService userService;
	// @RequestMapping("/getusers")
	// @ResponseBody
	// public List getUsers(){
	// Map<String,Object> map=new HashMap<String, Object>();
	// List<Users> list=usersmapper.getAll();
	// //map.put("list", list);
	// //return map.put("list", list);
	// return userService.getAll();
	// }
	// @RequestMapping("/index")
	// @ResponseBody
	// public String get() {
	// return "index--张三";
	// }

}
