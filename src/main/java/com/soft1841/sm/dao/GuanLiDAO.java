package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.GuanLi;

import java.sql.SQLException;
import java.util.List;

public interface GuanLiDAO  {
    /**
     * 查询所有的管理员的信息
     * @return
     * @throws SQLException
     */
    List<GuanLi> selectGuanLi()throws SQLException;

    /**
     * 根据id来查找制定管理员的信息
     * @param id
     * @return
     */
    Entity getGuanLiById (long id) throws SQLException;

    /**
     * 根据id来删除管理员的信息
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(long id) throws SQLException;

    /**
     * 新增管理员的信息
     * @param
     * @return
     * @throws SQLException
     */
    long insertGuanLi(GuanLi guanLi) throws  SQLException;
}
