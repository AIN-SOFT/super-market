package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GuanLiDAO;
import com.soft1841.sm.entity.GuanLi;
import com.soft1841.sm.service.GuanLiService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuanLiServiceImpl implements GuanLiService {
    private GuanLiDAO guanLiDAO = DAOFactory.getGuanLiInstance();
    @Override
    public List<GuanLi> getAllGuanLis() {
        List<GuanLi> guanLiList = new ArrayList<>();
        try {
            guanLiList = guanLiDAO.selectGuanLi();
        }catch (SQLException e){
            System.out.println("查询所有管理员的信息");
        }
        return guanLiList;
    }

    @Override
    public void deleteGuanLi(long id) {
        try {
            guanLiDAO.deleteById(id);
        } catch (SQLException e) {
            System.out.println("删除管理员的信息");
        }
    }
    @Override
    public Long addGuanLi(GuanLi guanLi) {
        long result = 0;
        try {
            result = guanLiDAO.insertGuanLi(guanLi);
        }catch (SQLException e){
            System.out.println("新增vip出项异常");
        }
        return result;
    }
}
