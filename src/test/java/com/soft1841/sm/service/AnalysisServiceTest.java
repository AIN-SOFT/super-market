package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;


public class AnalysisServiceTest {
    private AnalysisService analysisService = ServiceFactory.getAnalysisServiceInstance();

    @Test
    public void getTypeCount() {
        int n = analysisService.getTypeCount();
        System.out.println(n);
    }

    @Test
    public void getGoodsCount() {
        int n = analysisService.getGoodsCount();
        System.out.println(n);
    }
}
