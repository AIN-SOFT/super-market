package com.soft1841.sm.service;

import com.soft1841.sm.entity.Good;

import java.util.List;

/**
 * 商品的业务逻辑接口
 * @auther 许源
 * 2018年12月26日
 */
public interface GoodService {
    /**
     * 查询所有商品
     * @return
     */
    List<Good> getAllGoods();
    /**
     * 新增图书，返回自增主键
     * @param good
     * @return
     */
    Long addGoods(Good good);

    /**
     * 根据删除商品id
     * @param id
     */


    void  deleteGood(long id);
    /**
     * 更新商品信息
     * @param good
     * @return
     */
 void updateGood(Good good);
    /**
     * 根据id查询商品信息
     *
     * @param id
     * @return Book
     */
 Good getGood(long id);
/**
 * 根据书名关键词模糊查询商品
 *
 * @param keywords
 * @return List<Good>
 */
List<Good> getGoodsLike(String keywords);
    /**
     * @param typeId
     * @return List<商品>
     */
List<Good> getGoodsByTypeId(long typeId);
    /**
     * 根商品书类别统计商品数量
     *
     * @param typeId
     * @return
     */
int countByType(long typeId);


}
