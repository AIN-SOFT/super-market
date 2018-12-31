package com.soft1841.sm.dao;


import com.soft1841.sm.entity.Good;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品DAO接口
 * @auther 许源
 * 2018年12月26日
 */
public interface GoodDAO {
    /**
     * 增加商品
     * @param good
     * @return
     * @throws SQLException
     */

    Long insertGood(Good good) throws SQLException;
    /**
     * 根据id删除商品
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteGoodById(long id) throws SQLException;
    /**
     * 更新商品信息
     * @param good
     * @return
     * @throws SQLException
     */
    int updateGood(Good good) throws SQLException;

    /**
     * 查询所有商品
     *
     * @return
     * @throws SQLException
     */
    List<Good> selectAllGoods() throws SQLException;
    /**\
     * 根据id查商品
     * @param id
     * @return
     * @throws SQLException
     */
    Good getGoodById(long id) throws  SQLException;
    /**
     * 根据类别查商品
     * @param typeId
     * @return
     * @throws SQLException
     */
  List<Good>selectGoodByTypeId(long typeId) throws SQLException;
    /**
     * 根据关键词查商品
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Good> selectGoodLike(String keywords) throws  SQLException;
    /**
     * 根据类别统计商品数量
     * @param typeId
     * @return
     * @throws SQLException
     */
    int countByType(long typeId) throws  SQLException;

    /**
     * 统计商品总数
     * @return
     * @throws SQLException
     */
    int countGoods() throws SQLException;
}



