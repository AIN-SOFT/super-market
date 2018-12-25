package com.soft1841.sm.dao;

import com.soft1841.sm.entity.QianTai;
import java.sql.SQLException;

/**
 * 前台DAO 接口
 * @auther 徐鹏
 * 2018年12月25日
 */
public interface QianTaiDAO {
    /**
     *
     * @param number
     * @return
     * @throws SQLException
     */
     QianTai getQianTaiByNumber(String number)throws SQLException;

}
