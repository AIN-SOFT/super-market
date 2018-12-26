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
}