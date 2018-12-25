package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品类别DAO接口
 * @auther 徐鹏
 * 2018年12月24日
 */
public interface TypeDAO {

    /**
     * 新增商品类别, 返回自增主键(Long)
     * @param type
     * @return
     */
    Long insertType(Type type) throws SQLException;

    /**
     * 根据id删除类别
     * @param id
     * @return
     */
    int deleteTypeById(long id) throws SQLException;

    /**
     * 查询所有类别
     * @return
     */
    List<Entity> selectAllTypes() throws SQLException;

    /**
     * 根据id查询类别信息
     * @param id
     * @return
     */
    Entity getTypeById(int id) throws SQLException;

}