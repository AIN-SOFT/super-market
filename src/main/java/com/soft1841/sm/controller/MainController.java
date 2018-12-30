package com.soft1841.sm.controller;


import com.soft1841.sm.entity.GuanLi;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.crypto.interfaces.PBEKey;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * 后台主界面
 * @auther 徐鹏
 * 2018年12月24日
 */
public class MainController implements Initializable {
    @FXML
    private StackPane mainContainer;
    @FXML
    private Label timeLabel;
    //退出系统
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void initialize(URL location, ResourceBundle resources) {
        //启一个线程，用来同步获取系统时间
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //获取系统当前时间
                    LocalDateTime now = LocalDateTime.now();
                    //格式化时间
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
                    String timeString = dateTimeFormatter.format(now);
                    //启一个UI线程
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //将格式化后的日期时间显示在标签上
                            timeLabel.setText(timeString);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                }
            }
        }).start();

        try {
            AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/default.fxml")).load();
            mainContainer.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    //显示管理员的信息
    public void listGuanLi() throws Exception{
        switchView("guanli.fxml");
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
