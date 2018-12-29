package com.soft1841.sm.service;

import com.soft1841.sm.entity.GuanLi;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GuanLiServiceTest {

    private GuanLiService guanLiService = ServiceFactory.getGuanLiServiceInstance();
    @Test
    public void getAllGuanLis() throws SQLException {
        List<GuanLi> guanLiList = guanLiService.getAllGuanLis();
        guanLiList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void deleteGuanLi() {
  guanLiService.deleteGuanLi(1);
    }

    @Test
    public void addGuanLi() throws SQLException{
        GuanLi guanLi = new GuanLi();
        guanLi.setName("测试管理员名字");
        guanLi.setXinbie("男");
        guanLi.setPicture("http://www.gx8899.com/uploads/allimg/160804/3-160P4111639.jpg");
        guanLi.setXueli("学历");
        guanLi.setMobile("会员手机号码");
        System.out.println(guanLiService.addGuanLi(guanLi));
    }
}
