package com.slsd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.slsd.dao.ITeacherDao;
import com.slsd.entity.Teacher;
import com.slsd.service.ITeacherService;

@Service("teacherService")
public class ITeacherServiceImpl implements ITeacherService {
	@Resource
	private ITeacherDao teacherDao;

	public List<Teacher> findAllTeacher() {
		return teacherDao.findAllTeacher();
	}

	public Teacher findTeacherById(int tid) {
		return teacherDao.findTeacherById(tid);
	}

	public boolean addTeacher(Teacher teacher) {
		return (teacherDao.addTeacher(teacher) > 0) ? true : false;
	}

	public boolean editTeacher(Teacher teacher) {
		return (teacherDao.editTeacher(teacher) > 0) ? true : false;
	}

	public boolean delTeacher(int tid) {
		return (teacherDao.delTeacher(tid) > 0) ? true : false;
	}

}
