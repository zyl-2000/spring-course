package com.bjpowernode;

import com.bjpowernode.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest1 {
    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //someService:com.sun.proxy.$Proxy6：jdk的动态代理
        SomeService someService = (SomeService) ac.getBean("someService");
        System.out.println("someService:" + someService.getClass().getName());
        someService.doSome("a",12);
    }


}
