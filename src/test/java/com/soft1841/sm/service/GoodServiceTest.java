package com.soft1841.sm.service;

import com.soft1841.sm.entity.Good;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import javax.xml.ws.Service;

import java.util.List;

import static org.junit.Assert.*;

public class GoodServiceTest {
    private GoodService goodService = ServiceFactory.getGoodsServiceInstance();

    @Test
    public void getAllGoods() {
        List<Good> goodsList = goodService.getAllGoods();

        goodsList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void addGoods() {
        Good good = new Good();
        good.setTypeId(1);
        good.setName("测试");
        good.setPrice(22);
        good.setCover("https://hhhhhh.com/jjj.jpg");
        good.setStock(2);
        good.setSummary("描述");
        System.out.println(goodService.addGoods(good));
    }

    @Test
    public void getGood() {
        System.out.println(goodService.getGood(1));
    }

    @Test
    public void getGoodsLike() {
        List<Good> goodList = goodService.getGoodsLike ( "少" );

        goodList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void getGoodsByTypeId() {
        List<Good> goodList = goodService.getGoodsByTypeId ( 1 );

        goodList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void countByType() {

        int n = goodService.countByType(1);

        System.out.println(n);



    }

    @Test
    public void deleteGood() {
        goodService.deleteGood(161);
    }

    @Test
    public void updateGood() {
        Good good = new Good (  );
        good.setId ( 161 );
        good.setPrice(11.1);
    }
}