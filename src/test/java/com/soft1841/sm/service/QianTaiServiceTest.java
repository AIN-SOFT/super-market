package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class QianTaiServiceTest {
private QianTaiService qianTaiService = ServiceFactory.getQianTaiServiceInstance();

    @Test
    public void qiantailogin() {
        boolean flag = qianTaiService.qiantailogin("2","2");
        assertEquals(true,flag);

    }
}