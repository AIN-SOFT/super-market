package com.soft1841.sm.service;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Vip;
import java.util.List;

/**
 * vip业务查询接口
 */

public interface VipService {
    /**
     * 查询所有Vip信息
     * @return List<Vip>
     */
    List<Vip> getAllVips();

    /**
     * 根据id来找到某一个
     * @param id
     * @return
     */
    Entity getVip (long id);

    /**
     * 根据id来删除vip
     * @param id
     */
    void deleteVip(long id);

    /**
     * 新增一个vip，返回自增主键
     * @param vip
     * @return
     */
    Long addVip(Vip vip);
}
