package com.soft1841.sm.service;

/**
 * 前台业务逻辑接口
 * @auther 徐鹏
 * 2018年12月25日
 */
public interface QianTaiService {
    /**
     *
     * @param number
     * @param password
     * @return
     */
    boolean qiantailogin(String number, String password);
}
