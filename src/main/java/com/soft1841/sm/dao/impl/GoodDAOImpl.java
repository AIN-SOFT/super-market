package com.soft1841.sm.dao.impl;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.entity.Good;

import java.sql.SQLException;
import java.util.List;


public class GoodDAOImpl implements GoodDAO {

    @Override
    public Long insertGoods(Good goods) throws SQLException {
        return null;
    }

    @Override
    public int deleteGoodsById(long id) throws SQLException {
        return 0;
    }

    @Override
    public int updateGoods(Good goods) throws SQLException {
        return 0;
    }

    @Override
    public List<Entity> selectAllGoods() throws SQLException {
        return null;
    }

    @Override
    public Entity getGoodsById(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Entity> selectGoodsLike(String keywords) throws SQLException {
        return null;
    }

    @Override
    public List<Entity> selectGoodsByTypeId(long typeId) throws SQLException {
        return null;
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return 0;
    }
}
