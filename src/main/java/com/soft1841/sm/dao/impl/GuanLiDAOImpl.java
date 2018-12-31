package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GuanLiDAO;
import com.soft1841.sm.entity.GuanLi;
import com.soft1841.sm.entity.Vip;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 工作人员之管理员信息模块的展示
 * @author 侯粤嘉
 */
public class GuanLiDAOImpl implements GuanLiDAO {
    @Override
    public List<GuanLi> selectGuanLi() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_guanli");
        List<GuanLi> guanLiList = new ArrayList<>();
        //遍历entityList，转换为typeList
        for (Entity entity : entityList) {
            guanLiList.add(convertGuanli(entity));
        }
        return guanLiList;
    }

    @Override
    public Entity getGuanLiById(long id) throws SQLException {
        //采用自定义带参查询语句，返回单个实体
        return Db.use().queryOne("SELECT * FROM t_guanli WHERE id = ? ", id);
    }

    @Override
    public int deleteById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_guanli").set("id", id)
        );
    }

    @Override
    public long insertGuanLi(GuanLi guanLi) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_guanli")
                        .set("name", guanLi.getName())
                        .set("xinbie", guanLi.getXinbie())
                        .set("picture", guanLi.getPicture())
                        .set("xueli", guanLi.getXueli())
                        .set("mobile", guanLi.getMobile())
        );
    }


    @Override
    public int countGuanLi() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT (*) FROM t_guanli").intValue();
    }

    private GuanLi convertGuanli(Entity entity) {
        GuanLi guanLi = new GuanLi();
        guanLi.setId(entity.getLong("id"));
        guanLi.setName(entity.getStr("name"));
        guanLi.setXinbie(entity.getStr("xinbie"));
        guanLi.setXueli(entity.getStr("xueli"));
        guanLi.setPicture(entity.getStr("picture"));
        guanLi.setMobile(entity.getStr("mobile"));
        return guanLi;
    }
}
