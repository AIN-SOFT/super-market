package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Vip;
import java.sql.SQLException;
import java.util.List;

/**
 * Vip 的DAO 接口
 * @auther 侯粤嘉
 * 2018年12月24日
 */
public interface VipDAO {
    /**
     * 查询所有Vip的信息
     * @return
     * @throws SQLException
     */
    List<Vip> selectVip()throws SQLException;

    /**
     * 根据id来查询个别
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getVipById(long id) throws SQLException;

    /**
     * 根据id来删除会员信息
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(long id) throws SQLException;

    /**
     * 新增Vip的信息
     * @param vip
     * @return
     * @throws SQLException
     */
     long insertVip(Vip vip) throws SQLException;
}
