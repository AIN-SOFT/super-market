package com.soft1841.sm.service.impl;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.service.VipService;
import com.soft1841.sm.utils.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VipServiceImpl implements VipService {

    private VipDAO vipDAO = DAOFactory.getVipDAOInstance();

    @Override
    public List<Vip> getAllVips() {
        List<Vip> vipList = new ArrayList<>();
        try {
            vipList= vipDAO.selectVip();
        }catch (SQLException e){
            System.out.println("查询所有vip信息出项异常");
        }
        return vipList;
    }

    @Override
    public Entity getVip(long id) {
        Entity vip = new Entity();
        try {
            vip = vipDAO.getVipById(id);
        }catch (SQLException e){
            System.out.println("个别vip信息出现异常");
        }
        return vip;
    }

    @Override
    public void deleteVip(long id) {
    try {
        vipDAO.deleteById(id);
    }catch ( SQLException e){
        System.out.println("删除vip信息出现异常");
         }
    }

    @Override
    public Long addVip(Vip vip) {
        long result = 0 ;
        try {
            result = vipDAO.insertVip(vip);
        }catch (SQLException e){
            System.out.println("新增vip出项异常");
        }
        return result ;
    }
}
