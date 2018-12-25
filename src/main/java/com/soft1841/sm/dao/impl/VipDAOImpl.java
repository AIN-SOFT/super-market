package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;

import java.sql.SQLException;
import java.util.List;

public class VipDAOImpl implements VipDAO {
    @Override
    public List<Entity> selectVip() throws SQLException {
        return Db.use().query("SELECT * FROM t_vip ");
    }

    @Override
    public int deleteById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_vip").set("id",id)
        );
    }

    @Override
    public long insertVip(Vip vip) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_vip")
                        .set("name",vip.getName())
                        .set("year",vip.getYear())
                        .set("picture",vip.getPicture())
                        .set("jifen",vip.getJifen())
                        .set("mobile",vip.getMobile())
                        .set("address",vip.getAddress())
        );
    }
}
