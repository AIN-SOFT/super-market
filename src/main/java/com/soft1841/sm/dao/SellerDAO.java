package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Seller;

import java.sql.SQLException;

/**
 * 后台DAO 接口
 * @auther 徐鹏
 * 2018年12月24日
 */
public interface SellerDAO {
    /**
     * 根据工号查询收银员
     * @param number
     * @return
     * @throws SQLException
     */
    Seller getSellerByNumber(String number)throws SQLException;
}
