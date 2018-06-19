package com.slsd.dao;

import java.util.List;

import com.slsd.entity.Teacher;
public interface ITeacherDao {
	public List<Teacher> findAllTeacher();

	public Teacher findTeacherById(int tid);

	public int addTeacher(Teacher teacher);

	public int editTeacher(Teacher teacher);

	public int delTeacher(int tid);

}
