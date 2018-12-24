package com.soft1841.sm.utils;

import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.service.impl.SellerServiceImpl;

public class ServiceFactory {
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }
}
