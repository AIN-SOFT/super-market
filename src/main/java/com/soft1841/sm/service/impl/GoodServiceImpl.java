package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.entity.Good;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品的业务逻辑接口的实现类
 * @auther 许源
 * 2018年12月26日
 */
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

    @Override
    public Long addGoods(Good good) {
        long result = 0;
        try {
            result = goodDAO.insertGood(good);
        } catch (SQLException e) {
            System.err.println("新增商品出现异常");
        }
        return result;
    }

    @Override
    public void deleteGood(long id) {
        try {
            goodDAO.deleteGoodById(id);
        } catch (SQLException e) {
            System.err.println("删除商品出现异常");
        }
    }

    @Override
    public void updateGood(Good good) {
        try {
            goodDAO.updateGood(good);
        } catch (SQLException e) {
            System.err.println("修改商品信息出现异常");
        }

    }

    @Override
    public Good getGood(long id) {
       Good good  = new Good();
        try {
            good = goodDAO.getGoodById(id);
        } catch (SQLException e) {
            System.err.println("查询单个商品信息出现异常");
        }
        return good;
    }

    @Override
    public List<Good> getGoodsLike(String keywords) {
        List<Good> goodList = new ArrayList<>();
        try {
            goodList= goodDAO.selectGoodLike(keywords);
        } catch (SQLException e) {
            System.err.println("根据关键字查询商品信息出现异常");
        }
        return goodList;
    }

    @Override
    public List<Good> getGoodsByTypeId(long typeId) {
        List<Good> goodList = new ArrayList<>();
        try {
            goodList = goodDAO.selectGoodByTypeId(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别查询S商品信息出现异常");
        }
        return goodList;
    }

    @Override
    public int countByType(long typeId) {
        int result = 0;
        try {
            result = goodDAO.countByType(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别统计商品信息出现异常");
        }
        return result;
    }
    }
