package com.bjpowernode;

import com.bjpowernode.ba06.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest6 {
    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //someService:com.sun.proxy.$Proxy6：jdk的动态代理
        SomeService someService = (SomeService) ac.getBean("someService");
        System.out.println(someService.getClass().getName());
        someService.doThird("ad",22);


    }





}
