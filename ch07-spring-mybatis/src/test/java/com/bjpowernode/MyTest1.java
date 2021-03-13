package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest1 {

    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中对象的名称：" + beanDefinitionName + "|||"
                    + beanDefinitionName + ctx.getBean(beanDefinitionName).getClass().getName());
        }

    /*    SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = mapper.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }*/
    }

    @Test
    public void test2() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");

        List<Student> studentList = studentDao.selectStudents();
        System.out.println(studentList);
    }

    @Test
    public void test3() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ctx.getBean("studentService");
       // int num = studentService.addStudent(new Student(1008, "李小龙", "lxl@123.com", 23));
        //System.out.println(num);
        List<Student> studentList = studentService.queryStudents();
        //spring和mybatis整合在一起时，事务是自动提交的
        System.out.println(studentList);
    }
}
