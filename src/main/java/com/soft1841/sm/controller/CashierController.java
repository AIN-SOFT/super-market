package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Good;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class CashierController {
    @FXML
    private TextField barCodeField;

    @FXML
    private javafx.scene.control.Button exitButton;

    @FXML
    private TableView<Good> goodsTable;

    //商品模型数据集合，可以实时相应数据变化，无需刷新
    private ObservableList<Good> goodsData = FXCollections.observableArrayList();
    //商品Service对象，从DAO工厂通过静态方法获得
    private GoodService goodsService = ServiceFactory.getGoodsServiceInstance();
    //商品集合，存放数据库商品表各种查询的结果
    private List<Good> goodsList = null;

    //显示商品表格数据方法
    private  void showGoodsData(List<Good> goodsList){
        goodsData.addAll(goodsList);
        goodsTable.setItems(goodsData);
    }

    //通过条码搜索商品事件
    public void barCodeEnter() throws Exception {
        String barCode = barCodeField.getText();
        goodsList = goodsService.getGoodsByBarCode(barCode);
        showGoodsData(goodsList);

    }



    @FXML
    public void exitButton() throws Exception {
        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 570, 395);
        scene.getStylesheets().add("/css/style.css");
        loginStage.setTitle("登录");
        loginStage.setMaximized(true);
        loginStage.setScene(scene);
        loginStage.show();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
