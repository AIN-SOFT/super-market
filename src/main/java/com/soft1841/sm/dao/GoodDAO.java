package com.soft1841.sm.dao;


import com.soft1841.sm.entity.Good;

import java.sql.SQLException;
import java.util.List;

/**许源
 * 商品DAO接口
 */
public interface GoodDAO {
    /**
     * 查询所有商品
     *
     * @return
     * @throws SQLException
     */
    List<Good> selectAllGoods() throws SQLException;

}