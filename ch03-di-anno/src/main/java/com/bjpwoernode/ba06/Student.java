package com.bjpwoernode.ba06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("myStudent")
public class Student {


   // @Value(value = "张飞")
    @Value("${myName}")
    private String name;
    @Value(value = "20")
    private Integer age;

    /**
     * 引用类型
     * @Resource： 来自jdk中的注解，spring框架提供了对这个注解功能的支持，可以使用它给引用类型赋值
     *             使用的也是自动注入原理，支持byName，byType，默认是byName
     * 位置：1、在属性定义的上面，无需set方法，推荐使用
     *      2、在set方法上面
     *
     * @Resource： 只是用byName方式，需要增加一个属性 name
     * name的值是bean的id（名称）
     */

    //默认是byName，先使用byName自动注入，如果byName赋值失败，在使用byType
    @Resource(name = "mySchool")
    private School school;

    public Student() {
        System.out.println("Student的无参构造");
    }

   /* public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
