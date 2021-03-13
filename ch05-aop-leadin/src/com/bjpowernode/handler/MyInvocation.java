package com.bjpowernode.handler;

import com.bjpowernode.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocation implements InvocationHandler {

    //目标对象，用来保存目标
    private Object target;//SomeServiceImpl类

    public MyInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用这个invoke（）
        Object res = null;
        System.out.println("invoke中的method：" + method.getName());
        System.out.println("invoke中的args：" + args);
        if ("doOther".equals(method.getName())){
            ServiceTools.doLog();
        }

        //执行目标类的方法，通过Method类实现
        System.out.println("invoke中的target：" + target);
        res = method.invoke(target,args);//SomeServiceImpl.doOther(),doSome()
        if ("doOther".equals(method.getName())){
            ServiceTools.doTrans();
        }

        //目标方法执行结果
        return res;
    }


}
