package com.soft1841.sm.utils;

import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.service.QianTaiService;
import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.service.impl.GoodServiceImpl;
import com.soft1841.sm.service.impl.QianTaiServiceImpl;
import com.soft1841.sm.service.impl.SellerServiceImpl;
import com.soft1841.sm.service.impl.TypeServiceImpl;

/**
 * 业务逻辑工厂
 */
public class ServiceFactory {
    /**
     * 商品类别
     * @return
     */
    public static TypeService getTypeServiceInstance() {
        return new TypeServiceImpl();
    }

    /**
     * 后台
     * @return
     */
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }

    /**
     * 前台
     * @return
     */
    public static QianTaiService getQianTaiServiceInstance() {
        return new QianTaiServiceImpl();
    }

    /**
     * s商品
     * @return
     */
    public static GoodService getGoodServiceInstance(){
        return new GoodServiceImpl();
    }

}
