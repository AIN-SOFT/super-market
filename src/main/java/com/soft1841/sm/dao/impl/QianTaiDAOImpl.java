package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.QianTaiDAO;
import com.soft1841.sm.entity.QianTai;

import java.sql.SQLException;

public class QianTaiDAOImpl implements QianTaiDAO {
    @Override
    public QianTai getQianTaiByNumber(String number) throws SQLException {
        Entity entity =  Db.use().queryOne("SELECT * FROM t_qiantai WHERE number = ? ",number );
        return convertQianTai(entity);
    }
    private QianTai convertQianTai(Entity entity){
        QianTai qianTai = new QianTai(entity.getLong("id"),entity.getStr("number"),
                entity.getStr("password"),entity.getStr("name"));
        return  qianTai;
    }
}
