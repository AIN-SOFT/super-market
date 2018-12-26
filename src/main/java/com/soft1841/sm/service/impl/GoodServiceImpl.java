package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.entity.Good;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodServiceImpl implements GoodService {
        private GoodDAO goodDAO = DAOFactory.getGoodDAOInstance();
    @Override
    public List<Good> getAllGoods() {
        List<Good> goodList = new ArrayList<>();
        try {
            goodList = goodDAO.selectAllGoods();
        }catch (SQLException e){
            System.out.println("查询商品信息异常");
        }
        return goodList;
    }
}
