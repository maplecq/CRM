package coms.slsd.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slsd.dao.ITeacherDao;
import com.slsd.entity.Teacher;
import com.slsd.service.ITeacherService;

//@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = { "classpath:spring/root-context.xml" })
public class ITeacherServiceImplTest {
	@Resource
	private ITeacherService teacherService = null;

	// @Before
	// public void init() {
	// ApplicationContext ctx = new
	// ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
	// teacherService = (ITeacherService) ctx.getBean("teacherService");
	// }
	@Test
	public void test01() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
		ITeacherDao idao = (ITeacherDao) ctx.getBean("iTeacherDao");
		System.out.println(idao.getClass());

	}

	@Test
	public void testFindAllTeacher() {
		List<Teacher> tlist = teacherService.findAllTeacher();
		System.out.println(tlist);
	}

	@Test
	public void testFindTeacherById() {
		Teacher teacher = teacherService.findTeacherById(49);
		System.out.println(teacher);
	}

	@Test
	public void testAddTeacher() {
		Teacher teacher = new Teacher("钱1212王拳王", "1212王拳王");
		boolean flag = teacherService.addTeacher(teacher);
		System.out.println(flag);
	}

	@Test
	public void testEditTeacher() {
		Teacher teacher = new Teacher(68, "钱王拳王", "钱王拳王");
		boolean flag = teacherService.editTeacher(teacher);
		System.out.println(flag);
	}

	@Test
	public void testDelTeacher() {
		boolean flag = teacherService.delTeacher(71);
		System.out.println(flag);
	}

}
