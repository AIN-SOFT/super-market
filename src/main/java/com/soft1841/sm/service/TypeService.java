package com.soft1841.sm.service;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;

import java.util.List;

/**
 * 商品类别业务逻辑接口
 * @auther 徐鹏
 * 2018年12月24日
 */
public interface TypeService {
    /**
     * 获取所有商品类别的功能
     * @return
     */
    List<Entity> getAllTypes();

    /**
     * 根据id查询类别
     * @param id
     * @return
     */
    Entity getType(long id);

    /**
     * 增加类别
     * @param type
     * @return
     */
    Long addType(Type type);

    /**
     * 删除类别
     * @param id
     */
     void deleteType(long id);
}

