package com.soft1841.sm.service;


import com.soft1841.sm.entity.GuanLi;

import java.util.List;

public interface GuanLiService {
    /**
     * 查询所有管理员的信息
     * @return
     */
    List<GuanLi>  getAllGuanLis();


    /**
     * 根据id来删除管理员的信息
     * @param id
     */
    void deleteGuanLi(long id);

    /**
     * 新增一个管理员，返回主键自增
     * @param guanLi
     * @return
     */
   Long addGuanLi(GuanLi guanLi);
}
