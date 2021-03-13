package com.bjpwoernode;

import com.bjpwoernode.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("Studnet="+ myStudent);
    }
}
