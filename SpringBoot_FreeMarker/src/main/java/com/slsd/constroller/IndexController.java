package com.slsd.constroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(Map<String,Object> map) {
		System.out.println("sssss");
		map.put("name", "浙江水利水电");
		return "index";
		
	}
}
