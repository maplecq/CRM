package com.slsd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.slsd.dao.ITeacherDao;
import com.slsd.entity.Teacher;

@Repository("teacherDao")
public class ITeacherDaoImpl extends SqlSessionDaoSupport implements ITeacherDao {
	@Autowired
	@Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<Teacher> findAllTeacher() {
		SqlSession sqlSession = this.getSqlSession();
		List<Teacher> tlist = sqlSession.selectList("findAllTeacher");
		return tlist;
	}

	public Teacher findTeacherById(int tid) {
		SqlSession sqlSession = this.getSqlSession();
		Teacher teacher = sqlSession.selectOne("findTeacherById", tid);
		return teacher;
	}

	public int addTeacher(Teacher teacher) {
		SqlSession sqlSession = this.getSqlSession();
		int row = sqlSession.insert("addTeacher", teacher);
		return row;
	}

	public int editTeacher(Teacher teacher) {
		SqlSession sqlSession = this.getSqlSession();
		int row = sqlSession.update("editTeacher", teacher);
		return row;
	}

	public int delTeacher(int tid) {
		SqlSession sqlSession = this.getSqlSession();
		int row = sqlSession.delete("delTeacher", tid);
		return row;
	}

}
