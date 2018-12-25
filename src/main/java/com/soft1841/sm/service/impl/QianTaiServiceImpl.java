package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.QianTaiDAO;
import com.soft1841.sm.entity.QianTai;
import com.soft1841.sm.service.QianTaiService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class QianTaiServiceImpl implements QianTaiService {
    private QianTaiDAO qianTaiDAO =  DAOFactory.getQianTaiDAOInstance();

    @Override
    public boolean qiantailogin(String number, String password) {
        QianTai qianTai = null;
        try {
            qianTai  = qianTaiDAO.getQianTaiByNumber(number);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }
        //根据工号查找成功
        if (qianTai  != null) {
            //比较密码
            if (password.equals(qianTai.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
