package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.entity.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品DAO 的实现类
 * @auther 许源
 * 1028年12月26日
 */
public class GoodDAOImpl implements GoodDAO {

    @Override
    public Long insertGood(Good good) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", good.getTypeId())
                        .set("name", good.getName())
                        .set("price", good.getPrice())
                        .set("cover", good.getCover())
                        .set("stock", good.getStock())
                        .set("summary", good.getSummary())
        );
    }

    @Override
    public int deleteGoodById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("id", id)
        );
    }

    @Override
    public int updateGood(Good good) throws SQLException {
        return Db.use().update(
                Entity.create().set("price",good.getPrice())
                .set("stock",good.getStock()),
                Entity.create("t_goods").set("id",good.getId())
        );
    }

    @Override
    public List<Good> selectAllGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods ");
        List<Good> goodList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodList.add(convertGood(entity));
        }
        return goodList;
    }

    @Override
    public Good getGoodById(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE id = ? ", id);
        return convertGood(entity);
    }

    @Override
    public List<Good> selectGoodByTypeId(long typeId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE type_id = ? ", typeId);
        List<Good> goodList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodList.add(convertGood(entity));
        }
        return goodList;
    }

    @Override
    public List<Good> selectGoodLike(String keywords) throws SQLException {
        List<Entity> entityList = Db.use().findLike("t_goods", "name", keywords, Condition.LikeType.Contains);
        List<Good> goodList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodList.add(convertGood(entity));
        }
        return goodList;
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ", typeId).intValue();

    }

    @Override
    public int countGoods() throws SQLException {
        return  Db.use().queryNumber("SELECT COUNT(*) FROM t_goods ").intValue();
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