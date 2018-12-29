package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Good;
import com.soft1841.sm.utils.DAOFactory;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class GoodDAOTest {
    private GoodDAO goodDAO = DAOFactory.getGoodDAOInstance();

    @Test
    public void selectAllGoods() throws SQLException {
        List<Good> goodList = goodDAO.selectAllGoods();
        goodList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void insertGood() throws SQLException {
        Good good = new Good();
        good.setTypeId(1);
        good.setName("测试");
        good.setPrice(22);
        good.setCover("https://hhhhhh.com/jjj.jpg");
        good.setStock(2);
        good.setSummary("描述");
        System.out.println(goodDAO.insertGood(good));
    }

    @Test
    public void deleteGoodById()  throws  SQLException{
      goodDAO.deleteGoodById(10);
    }

    @Test
    public void updateGood()  throws SQLException{
        Good good = new Good();
        good.setId(40);
        good.setPrice(11.1);
        good.setStock(99);
        goodDAO.updateGood(good);

    }


    @Test
    public void getGoodById() throws  SQLException{
     Good good = goodDAO.getGoodById(2);
        System.out.println(good.getName());
    }

    @Test
    public void selectGoodByTypeId()  throws  SQLException{
        List<Good>goodList = goodDAO.selectGoodByTypeId(1);
        goodList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void selectGoodLike()  throws  SQLException{
        List<Good> goodList = goodDAO.selectGoodLike("少");
        goodList.forEach(good -> System.out.println(good.getName()));
    }

    @Test
    public void countByType() throws  SQLException {
        int n =goodDAO.countByType(1);
        System.out.println(n);
    }
}