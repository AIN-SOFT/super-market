package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Good;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author 许源
 * 商品控制台
 */
public class GoodController implements Initializable{
    @FXML
    private TableView<Good> goodTable;
////    @FXML
//    private ComboBox<Type> typeComboBox;
    //自动更新
    private ObservableList<Good> goodsDate = FXCollections.observableArrayList();
    //
//    private ObservableList<Type> typeDate = FXCollections.observableArrayList();


    private GoodService goodService= ServiceFactory.getGoodServiceInstance();
    //类别TypeService对象
//    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    //商品集合，存放数据库表t_goods各种查询的结果
    private List<Good> goodsList = null;
    //类别集合，存放数据库类别表查询结果
//    private List<Good> typeList = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
//        initComBox();
    }
    //表格初始化
    private void initTable() {
        //水平方向不显示滚动条，表格的列宽会均匀分布
       goodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        goodsList = goodService.getAllGoods();
        //将实体集合作为参数，调用显示数据的方法，可以在界面的表格中显示商品模型集合的值
        showGoodsData(goodsList);

            }

    //显示商品表格数据的方法
    private void showGoodsData (List<Good>goodsList) {
        goodsDate.addAll(goodsList);
        goodTable.setItems(goodsDate);
    }
}

