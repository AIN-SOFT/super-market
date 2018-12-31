package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.service.AnalysisService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class AnalysisServiceImpl implements AnalysisService {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    private GoodDAO goodDAO = DAOFactory.getGoodDAOInstance();
    @Override
    public int getTypeCount() {
        int n = 0;
        try {
            n = typeDAO.countTypes();
        } catch (SQLException e) {
            System.err.println("统计异常");
        }
        return  n;
    }

    @Override
    public int getGoodsCount() {
        int n = 0 ;
        try {
            n = goodDAO.countGoods();
        }catch (SQLException e){
            System.err.println("统计总数异常");
        }
        return n ;
    }
}
