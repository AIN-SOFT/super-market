package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * vipDAO DE 实现类
 * @auther 侯粤嘉
 * 2018年12月26 日
 */
public class VipDAOImpl implements VipDAO {
    @Override
    public List<Vip> selectVip() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_vip ");
        List<Vip> vipList = new ArrayList<>();
        //遍历entityList，转换为typeList
        for (Entity entity:entityList) {
            vipList.add(convertType(entity));
        }
        return vipList;

    }

    @Override
    public Entity getVipById(long id) throws SQLException {
        //采用自定义带参查询语句，返回单个实体
        return Db.use().queryOne("SELECT * FROM t_vip WHERE id = ? ", id);
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

    private Vip convertType(Entity entity) {
        Vip vip = new Vip();
        vip.setId(entity.getLong("id"));
        vip.setName(entity.getStr("name"));
        vip.setYear(entity.getStr("year"));
        vip.setJifen(entity.getStr("jifen"));
        vip.setPicture(entity.getStr("picture"));
        vip.setAddress(entity.getStr("address"));
        vip.setMobile(entity.getStr("mobile"));
        return vip;
    }
}
