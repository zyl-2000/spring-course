package com.bjpowernode.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect: 是aspect框架中的注解
 *    作用：表示当前类是切面类。
 *    切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *    位置：在类定义的上面
 */
@Aspect
public class MyAspect {
    /**
     * 后置通知定义方法：方法是实现切面功能的
     * 方法的定义要求：
     * 1、共公方法：public
     * 2、方法没有返回值
     * 3、方法名称自定义
     * 4、方法有参数,推荐使用Object
     *
     */

    /**
     * @AfterReturning： 后置通知
     *   属性：1、value 切入点表达式
     *        2、returning 自定义的变量，表示目标方法的返回值的
     *          自定义变量名必须和通知方法的形参名一样
     *          通知方法就是myAfterReturning（）；
     *   位置：在方法定义的上面
     * 特点：
     * 1、在目标方法之后执行的
     * 2、能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *    Object res = doOther();
     * 3、可以修改返回值
     *
     *  后置通知的执行
     *    Object res = doOther();
     *    myAfterReturning(res);值传递
     */
    @AfterReturning(value = "execution( Student *..SomeServiceImpl.doOther2(..))",returning = "res")
    public void myAfterReturning2(Object res){
        //Object res:是目标方法执行后的返回值，根据返回值做你的切面功能的处理
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);

        //修改目标方法的返回值，看一下是否会影响最后方法的返回结果
        if(res != null){
            Student student = (Student)res;
            student.setAge(10);
        }
    }

    //JoinPoint参数必须放在所有参数的第一位
    @AfterReturning(value = "execution( String *..ba02.SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning(JoinPoint jp,Object res){

        System.out.println("后置通知方法的定义：" + jp.getSignature().getName());
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        //Object res:是目标方法执行后的返回值，根据返回值做你的切面功能的处理
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        if (res.equals("abcd")){
            //做一些功能
        }else {
            //其他功能
        }

        //修改目标方法的返回值，看一下是否会影响最后方法的返回结果
        if(res != null){
            res = "Hello Aspectj";
        }
    }


}