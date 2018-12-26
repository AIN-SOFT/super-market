package com.soft1841.sm.service;

/**
 * 后台业务逻辑接口
 * @auther 徐鹏
 * 2018年12月24日
 */
public interface SellerService {
    /**
     *
     * @param number
     * @param password
     * @return
     */
    boolean login(String number, String password);
}
