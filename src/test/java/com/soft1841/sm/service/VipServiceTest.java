package com.soft1841.sm.service;
import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class VipServiceTest {
private VipService vipService = ServiceFactory.getVipServiceInstance();

    @Test
    public void getAllVips()throws SQLException {
        List<Vip> vipList = vipService.getAllVips();
        vipList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void deleteVip() {
        vipService.deleteVip(1);
    }

    @Test
    public void addVip() {
        Vip vip =  new Vip();
        vip.setName("测试类别");
        vipService.addVip(vip);
    }

    @Test
    public void getVip() {
        System.out.println(vipService.getVip(1));
    }
}
