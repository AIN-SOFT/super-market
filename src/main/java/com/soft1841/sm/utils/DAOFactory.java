package com.soft1841.sm.utils;

import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.TypeDAOImpl;

/**
 * 工厂类，用静态方法来生成各个DAO实例
 */
public class DAOFactory {
    /**
     * 静态方法，返回TypeDAO实现类的对象
     * @return
     */
    public static TypeDAO getTypeDAOInstance() {
        return new TypeDAOImpl();
    }
}
