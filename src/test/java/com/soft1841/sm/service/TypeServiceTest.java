package com.soft1841.sm.service;


import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;


public class TypeServiceTest {
private TypeService typeService = (TypeService) ServiceFactory.getTypeServiceInstance();
    @Test
    public void getAllTypes() {
        List<Entity> typeList = typeService.getAllTypes();
        typeList.forEach(type-> System.out.println(type));
        }

    @Test
    public void getType() {
        System.out.println(typeService.getType(1));
    }

    @Test
    public void addType() {
        Type type = new Type();
        type.setTypeName("测试类别");
        typeService.addType(type);
    }

    @Test
    public void deleteType() {
        typeService.deleteType(2);
    }
}