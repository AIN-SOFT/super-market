package com.soft1841.sm.controller;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 后台主界面
 * @auther 徐鹏
 * 2018年12月24日
 */
public class MainController implements Initializable {
    @FXML
    private StackPane mainContainer;
    public void initialize(URL location, ResourceBundle resources) {
    }
    //显示默认主页数据
    public void listDefault() throws Exception {
        switchView("default.fxml");
    }

    //显示商品类别数据
    public void listType() throws Exception {
        switchView("type.fxml");
    }

    //显示商品数据
    public void listGoods() throws Exception {
        switchView("good.fxml");
    }

    //显示Vip的数据
    public  void listVip() throws Exception {
        switchView("Vip.fxml");
    }


    //封装一个切换视图的方法：用来根据fxml文件切换视图内容
    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = mainContainer.getChildren();
        mainContainer.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }
}
