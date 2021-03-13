package com.bjpowernode;

import com.bjpowernode.service.BuyGoodsService;
import com.bjpowernode.service.impl.BuyGoodsServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest1 {
    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyService = (BuyGoodsService) ctx.getBean("buyService");
        System.out.println("service是代理：" + buyService.getClass().getName());
        buyService.buy(1001,1);

    }
}
