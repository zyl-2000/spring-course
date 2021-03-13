package com.bjpowernode;

import com.bjpowernode.ba02.SomeService;
import com.bjpowernode.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest2 {
    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //someService:com.sun.proxy.$Proxy6：jdk的动态代理
        SomeService someService = (SomeService) ac.getBean("someService");
        String asd = someService.doOther("asd", 12);
        System.out.println(asd);

    }

    @Test
    public void test2(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //someService:com.sun.proxy.$Proxy6：jdk的动态代理
        SomeService someService = (SomeService) ac.getBean("someService");
        Student asd = someService.doOther2("asd", 12);
        System.out.println(asd);

    }



}
