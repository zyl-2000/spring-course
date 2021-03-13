package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strId = req.getParameter("id");
        String strName = req.getParameter("name");
        String strEmail = req.getParameter("email");
        String strAge = req.getParameter("age");

        //创建spring容器的配置对象
//        String config = "spring.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        WebApplicationContext ctx = null;
        //获取ServletContext中的容器对象，创建好的容器对象，拿来就用
     /*   String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = getServletContext().getAttribute(key);
        if (attr != null){
            ctx = (WebApplicationContext) attr;
        }*/

        //使用框架中的方法，获取容器对象
        ServletContext servletContext = getServletContext();
        ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        System.out.println("容器对象的信息:====" + ctx);
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student(Integer.parseInt(strId),strName,strEmail,Integer.valueOf(strAge));
        int i = studentService.addStudent(student);
        List<Student> studentList = studentService.queryStudents();

        req.getRequestDispatcher("/result.jsp").forward(req,resp);


    }
}
