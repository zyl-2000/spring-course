package com.bjpowernode;

import com.bjpowernode.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    /**
     * spring默认创建对象的时间：在创建spring对象的容器时，会创建配置文件中的所有对象
     */
    @Test
    public void test01(){
        //使用spring容器去创建对象
        //1、指定spring配置文件的名称，路径为类的根路径
        String config = "beans.xml";
        //2、创建表示spring的容器对象，ApplicationContext
        //ApplicationContext就表示spring容器，通过容器获取对象
        //ClassPathXmlApplicationContext表示从类路径中加载路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，你要调用对象的方法
        SomeService someService = (SomeService) applicationContext.getBean("someService");
        someService.doSome();

    }

    /**
     * 获取spring容器中Java对象的信息
     */
    @Test
    public void test02(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法，获取容器中定义的对象的数量
        int beanDefinitionCount = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量：" + beanDefinitionCount);
        //容器中定义的对象的名称
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("对象id：" + beanDefinitionName);
        }

    }
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
       //获取一个非自定义类的对象
        Date mydate = (Date) ac.getBean("mydate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(mydate);
        System.out.println(format);
    }
}
