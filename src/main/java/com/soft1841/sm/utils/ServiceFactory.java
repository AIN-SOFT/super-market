package com.soft1841.sm.utils;

import com.soft1841.sm.service.*;
import com.soft1841.sm.service.impl.*;

/**
 * 业务逻辑工厂
 */
public class ServiceFactory {
    public static TypeService getTypeServiceInstance() {
        return new TypeServiceImpl();
    }
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }
    public static QianTaiService getQianTaiServiceInstance(){
        return new QianTaiServiceImpl();
    }
    public static VipService getVipServiceInstance(){return new VipServiceImpl();}
    public static GoodService getGoodsServiceInstance(){return  new GoodServiceImpl(); }
    public static GuanLiService getGuanLiServiceInstance(){return  new GuanLiServiceImpl();}
    public static AnalysisService getAnalysisServiceInstance(){return  new AnalysisServiceImpl(); }
}
