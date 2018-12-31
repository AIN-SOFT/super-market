package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.GuanLi;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class GuanLiDAOTest {
    private GuanLiDAO guanLiDAO = DAOFactory.getGuanLiInstance();
    @Test
    public void selectGuanLi() throws SQLException {
        List<GuanLi> guanList = guanLiDAO.selectGuanLi();
        guanList.forEach(entity -> System.out.println());
    }

    @Test
    public void getGuanLiById()throws SQLException {
        Entity GuanLi = guanLiDAO.getGuanLiById(1);
        System.out.println(GuanLi);
    }

    @Test
    public void deleteById() throws SQLException{
        guanLiDAO.deleteById(2);
    }

    @Test
    public void insertGuanLi() throws SQLException{
        GuanLi guanLi = new GuanLi();
        guanLi.setName("新增管理员信息");
        System.out.println(guanLiDAO.insertGuanLi(guanLi));}
}
