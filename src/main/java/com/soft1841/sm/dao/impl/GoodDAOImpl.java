package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.entity.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO {

    @Override
    public List<Good> selectAllGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods ");
        List<Good> goodList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodList.add(convertGood(entity));
        }
        return goodList;
    }

    /**
     * @param entity
     * @return
     */
    private Good convertGood(Entity entity) {
        Good good = new Good();
        good.setId(entity.getLong("id"));
        good.setTypeId(entity.getLong("type_id"));
        good.setName(entity.getStr("name"));
        good.setPrice(entity.getDouble("price"));
        good.setCover(entity.getStr("cover"));
        good.setStock(entity.getInt("stock"));
        good.setSummary(entity.getStr("summary"));
        return good;
    }

}