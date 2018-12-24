package com.soft1841.sm.dao.impl;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;
import java.sql.SQLException;
import java.util.List;


public class GoodsDAOImpl implements GoodsDAO  {

    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", goods.getTypeId())
                        .set("name", goods.getName())
                        .set("price", goods.getPrice())
                        .set("cover", goods.getCover())
                        .set("number", goods .getNumber())
                        .set("describe",goods.getDescribe())
        );
    }

    @Override
    public int deleteGoodsById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("id", id)
        );
    }


    @Override
    public int updateGoods(Goods goods) throws SQLException {
        //只修改了商品的价格和库存
        return Db.use().update(
                Entity.create().set("price", goods.getClass())
                        .set("stock",goods.getClass()),
                Entity.create("t_goods").set("id", goods.getClass())
        );
    }

    @Override
    public List<Entity> selectAllGoods() throws SQLException {
        return Db.use().query("SELECT * FROM t_goods ");

    }

    @Override
    public Entity getGoodsById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_goods WHERE id = ? ", id);
    }

    @Override
    public List<Entity> selectGoodsLike(String keywords) throws SQLException {
        return Db.use().findLike("t_goods", "name", keywords, Condition.LikeType.Contains);
    }

    @Override
    public List<Entity> selectGoodsByTypeId(long typeId) throws SQLException {
        return Db.use().query("SELECT * FROM t_goods WHERE type_id = ? ", typeId);
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ", typeId).intValue();

    }


}
