package com.bjpowernode;

import com.bjpowernode.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest7 {
    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //someService:com.sun.proxy.$Proxy6：jdk的动态代理
        SomeServiceImpl someService = (com.bjpowernode.ba07.SomeServiceImpl) ac.getBean("someService");
        /**
         * 目标类没接口使用的是cglib动态代理，spring框架会自动的去应用cglib动态代理
         * //com.bjpowernode.ba07.SomeServiceImpl$$EnhancerBySpringCGLIB$$fb552ea9
         */
        System.out.println(someService.getClass().getName());
        someService.doThird("ad",22);


    }





}
