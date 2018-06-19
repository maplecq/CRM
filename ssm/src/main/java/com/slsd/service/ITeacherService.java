package com.slsd.service;

import java.util.List;

import com.slsd.entity.Teacher;

public interface ITeacherService {
	public List<Teacher> findAllTeacher();

	public Teacher findTeacherById(int tid);

	public boolean addTeacher(Teacher teacher);

	public boolean editTeacher(Teacher teacher);

	public boolean delTeacher(int tid);

}
