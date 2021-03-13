package com.bjpowernode;

import com.bjpowernode.ba04.School;
import com.bjpowernode.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {

    @Test
    public void test01(){
        //使用spring容器去创建对象
        //1、指定spring配置文件的名称，路径为类的根路径
        String config = "ba03/applicationContext.xml";
        //2、创建表示spring的容器对象，ApplicationContext
        //ApplicationContext就表示spring容器，通过容器获取对象
        //ClassPathXmlApplicationContext表示从类路径中加载路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("myStudent");
        System.out.println(student);

        School school = (School) applicationContext.getBean("school");
        System.out.println(school);


    }

    @Test
    public void test02(){
        //使用spring容器去创建对象
        //1、指定spring配置文件的名称，路径为类的根路径
        String config = "ba04/applicationContext.xml";
        //2、创建表示spring的容器对象，ApplicationContext
        //ApplicationContext就表示spring容器，通过容器获取对象
        //ClassPathXmlApplicationContext表示从类路径中加载路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("myStudent");
        System.out.println(student);

        School school = (School) applicationContext.getBean("school");
        System.out.println(school);
    }

}
