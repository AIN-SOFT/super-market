package com.soft1841.sm.service;

import com.soft1841.sm.entity.Good;

import java.util.List;

public interface GoodService {
    /**
     * 查询所有商品
     * @return
     */
    List<Good> getAllGoods();
}
