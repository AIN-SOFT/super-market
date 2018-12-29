package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别的DAO实现类
 * @auther 徐鹏
 *2018年12月24日
 */
public class TypeDAOImpl implements TypeDAO {

    @Override
    public Long insertType(Type type) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_type")
                        .set("type_name", type.getTypeName())
        );
    }

    @Override
    public int deleteTypeById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_type").set("id", id)
        );
    }


    @Override
    public List<Type> selectAllTypes() throws SQLException {
        //查询得到List<Entity>
        List<Entity> entityList =  Db.use().query("SELECT * FROM t_type ");
        //创建一个List<Type>，存放具体的图书类别
        List<Type> typeList = new ArrayList<>();
        //遍历entityList，转换为typeList
        for (Entity entity:entityList) {
            typeList.add(convertType(entity));
        }
        return typeList;
    }

    @Override
    public Type getTypeById(long id) throws SQLException {
        //采用自定义带参查询语句，返回单个实体
        Entity entity = Db.use().queryOne("SELECT * FROM t_type WHERE id = ? ", id);
        //将Entity转换为Type类型返回
        return convertType(entity);
    }
    private Type convertType(Entity entity) {
        Type type = new Type();
        type.setId(entity.getLong("id"));
        type.setTypeName(entity.getStr("type_name"));
        return type;
    }
}
