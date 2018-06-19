package com.slsd.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.slsd.entity.Teacher;
import com.slsd.service.ITeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	// /teacher/test?id=1
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		int tid = Integer.parseInt(request.getParameter("id"));
		System.out.println("tid:" + tid);
		Teacher teacher = null;
		if (tid == 1) {
			teacher = new Teacher();
			teacher.setTid(1);
			teacher.setTname("zs");
		}

		model.addAttribute("teacher", teacher);
		return "index";
	}

	// /teacher/showTeacher?id=1
	@RequestMapping(value = "/showTeacher", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request, Model model) {
		int tid = Integer.parseInt(request.getParameter("id"));
		System.out.println("tid:" + tid);
		Teacher teacher = this.teacherService.findTeacherById(tid);
		model.addAttribute("teacher", teacher);
		return "showTeacher";
	}

	// /teacher/showTeacher2?id=1
	@RequestMapping(value = "/showTeacher2", method = RequestMethod.GET)
	public String toIndex2(@RequestParam("id") String id, Model model) {
		int tid = Integer.parseInt(id);
		System.out.println("tid:" + tid);
		Teacher teacher = this.teacherService.findTeacherById(tid);
		model.addAttribute("teacher", teacher);
		return "showTeacher";
	}

	// 请求/teacher/showTeacher3/12
	@RequestMapping(value = "/showTeacher3/{id}", method = RequestMethod.GET)
	public String toIndex3(@PathVariable("id") String id, Map<String, Object> model) {
		int tid = Integer.parseInt(id);
		System.out.println("tid:" + tid);
		Teacher teacher = this.teacherService.findTeacherById(tid);
		model.put("teacher", teacher);
		return "showTeacher";
	}

	

	@Resource
	private ITeacherService teacherService;

	/**
	 * 请求地址 teacher/showAll 查询用户所有信息
	 * 
	 * @param model
	 *            附加内容给前台页面
	 * @return 视图 /WEB-INF/jsp/视图.jsp
	 */
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String showAll(Map<String, Object> model) {
		List<Teacher> tlist = this.teacherService.findAllTeacher();
		model.put("tlist", tlist);
		return "index";
	}
	/**
	 * 删除信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delTeacher", method = RequestMethod.GET)
	public String delTea(@PathVariable("id") String id, Map<String, Object> model) {
		int tid = Integer.parseInt(id);
		boolean flag = this.teacherService.delTeacher(tid);
		if (flag) {
			List<Teacher> tlist = this.teacherService.findAllTeacher();
			model.put("tlist", tlist);
			return "index";
		} else {
			return "error";
		}
	}

	/**
	 * 页面跳转 跳转到 /WEB-INF/jsp/addTeacher.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doadd", method = RequestMethod.GET)
	public String doadd() {
		return "addTeacher";
	}

	/**
	 * 执行添加操作
	 * 
	 * @param tea
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.POST)
	// @PostMapping("addPage")
	public String addPage(Teacher tea, Map<String, Object> model) {
		boolean flag = this.teacherService.addTeacher(tea);
		if (flag) {
			List<Teacher> tlist = this.teacherService.findAllTeacher();
			model.put("tlist", tlist);
			return "index";
		} else {
			return "error";
		}
	}
	/**
	 * 跳转到到editTeacher.jsp
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doedit/{id}", method = RequestMethod.GET)
	public String doedit(@PathVariable("id") String id, Map<String, Object> model) {
		int tid = Integer.parseInt(id);
		Teacher teacher = this.teacherService.findTeacherById(tid);
		model.put("teacher", teacher);
		return "editTeacher";
	}

	/**
	 * 执行修改操作
	 * 
	 * @param tea
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editPage", method = RequestMethod.POST)
	public String editPage(Teacher tea, Map<String, Object> model) {
		System.out.println(tea);
		boolean flag = this.teacherService.editTeacher(tea);
		System.out.println(flag);
		if (flag) {
			List<Teacher> tlist = this.teacherService.findAllTeacher();
			model.put("tlist", tlist);
			return "index";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/dodel/{id}", method = RequestMethod.GET)
	public String dodel(@PathVariable("id") String id, Map<String, Object> model) {
		int tid = Integer.parseInt(id);
		boolean flag = this.teacherService.delTeacher(tid);
		if (flag) {
			List<Teacher> tlist = this.teacherService.findAllTeacher();
			model.put("tlist", tlist);
			return "index";
		} else {
			return "error";
		}
	}
	
	// json格式
		@RequestMapping(value = "/testRequestBody")
		// @ResponseBody会将集合数据转换json格式返回客户端
		@ResponseBody
		public Object getJson(@RequestBody Teacher tea) {
			// 使用@RequestBody注解获取到json数据后，将json数据设置到对应的Teacher对象的属性中
			System.out.println(tea);
			Teacher teacher = this.teacherService.findTeacherById(tea.getTid());
			return teacher;
		}
	// dodel
	// 文件上传、
}
