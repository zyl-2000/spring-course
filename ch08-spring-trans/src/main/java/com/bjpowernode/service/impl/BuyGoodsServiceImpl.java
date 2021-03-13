package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.dao.SaleDao;
import com.bjpowernode.domain.Goods;
import com.bjpowernode.domain.Sale;
import com.bjpowernode.service.BuyGoodsService;
import com.bjpowernode.wxcep.NotEnoughException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /**
     *
     * rollbackFor:表示发生指定异常时一定回滚
     * 处理逻辑是：
     *   1）spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性中
     *      如果异常在rollbackFor的列表中，不管什么类型的异常，一定回滚
     *   2）如果你的抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException，
     *      如果是，一定回滚
     * */
   /* @Transactional(
            //传播行为
            propagation = Propagation.REQUIRED,
            //隔离级别
            isolation = Isolation.DEFAULT,
            //是否只读（只进行查询操作）
            readOnly = false,
            //抛出指定异常时进行回滚
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )*/
    @Transactional//等同于以上写法，以上皆为默认写法，此注解必须使用在公开的方法上（public）
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("===========buy方法的开始========");
        //1、记录销售信息，向sale表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //2、更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null){
            //商品不存在
            throw new NullPointerException("编号是：" + goodsId + ",商品不存在");
        }else if(goods.getAmount() < nums){
            throw new NotEnoughException("编号是：" + goodsId + "的商品库存不足");
        }

        goods.setAmount(nums);
        goodsDao.updateGoods(goods);
        System.out.println("========buy方法的完成======");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
