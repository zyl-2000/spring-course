package com.bjpowernode;

import com.bjpowernode.handler.MyInvocation;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
       /* SomeService someService = new SomeServiceImpl();
        someService.doSome();
        System.out.println("=====================");
        someService.doOther();*/

        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler = new MyInvocation(target);
        //使用Proxy创建代理：返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
        //参数：1、目标类的类加载器，2、目标类的实现接口，3、增加方法的对象（调度方法调用的调用处理函数 ）
        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        //通过代理执行方法，会调用handler中的invoke（）
        proxy.doOther();
        System.out.println("===================");
        proxy.doSome();

    }
}
