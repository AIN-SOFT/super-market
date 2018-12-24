package com.soft1841.sm.utils;

import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.SellerDAOImpl;
import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.dao.impl.TypeDAOImpl;
import com.soft1841.sm.dao.impl.VipDAOImpl;
import com.soft1841.sm.entity.Vip;

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

    /**
     *
     * @return
     */
    public static SellerDAO getSellerDAOInstance() {
        return new SellerDAOImpl();
    }
    public static VipDAO getVipDAOInstance(){ return new VipDAOImpl(); }
}
