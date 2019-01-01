package com.soft1841.sm.utils;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.soft1841.sm.entity.Good;

import java.util.List;

public class ExcelExport {
    public static void export(List<Good> bookList) {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/goods.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(7, "商品信息表");
        // 一次性写出内容，使用默认样式
        writer.write(bookList);
        // 关闭writer，释放内存
        writer.close();
    }
}
