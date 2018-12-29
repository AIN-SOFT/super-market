package com.soft1841.sm.dao;
/**
 * type测试类
 * @auther 徐鹏
 * 2018年 12月25日
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class TypeDAOTest {
    private TypeDAO typeDAO = (TypeDAO) DAOFactory.getTypeDAOInstance();

    @Test
    public void insertType() throws SQLException{
        Type type = new Type();
        type.setTypeName("测试类别");
        System.out.println(typeDAO.insertType(type));
    }

    @Test
    public void deleteTypeById() throws SQLException{
        typeDAO.deleteTypeById(8);
    }

    @Test
    public void selectAllTypes() throws SQLException {
        List<Type> typeList = typeDAO.selectAllTypes();
        typeList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void getTypeById() throws  SQLException {
        Type type = typeDAO.getTypeById(2);
        System.out.println(type);
    }
}