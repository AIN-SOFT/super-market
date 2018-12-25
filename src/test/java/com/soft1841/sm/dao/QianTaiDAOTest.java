package com.soft1841.sm.dao;
/**
 * 前台number测试
 * @auther 徐鹏
 * 2018年12月25日
 */

import com.soft1841.sm.entity.QianTai;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

public class QianTaiDAOTest {
    private QianTaiDAO qianTaiDAO = (QianTaiDAO) DAOFactory.getQianTaiDAOInstance();

    @Test
    public void getQianTaiByNumber() throws SQLException {
        QianTai qianTai = qianTaiDAO.getQianTaiByNumber("2");
        System.out.println(qianTai);
    }

}