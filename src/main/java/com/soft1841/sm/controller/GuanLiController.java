package com.soft1841.sm.controller;
/**
 * 管理员信息的增，删，查
 * @author侯粤嘉
 */
import com.soft1841.sm.entity.GuanLi;
import com.soft1841.sm.service.GuanLiService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GuanLiController implements Initializable {
    @FXML
    private FlowPane guanliPane;
    private GuanLiService guanliService = ServiceFactory.getGuanLiServiceInstance();
    private List<GuanLi> guanliList = new ArrayList<>();
    @FXML
    private ImageView guanliImg;
    String[] imgPath2 = {"yuangong5.jpg", "yuangong2.jpg", "yuangong3.jpg", "yuangong4.jpg","yuangong5.jpg"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        guanliList = guanliService.getAllGuanLis();
        //读取数据库信息
        showGuanLi(guanliList);
        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath2.length; i++) {
                        //用每个资源创建一个图片象
                        Image image = new Image("/img/" + imgPath2[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                guanliImg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(2200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath2.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();
    }
    private void showGuanLi(List<GuanLi> guanliList) {
        //清除之前内容
        guanliPane.getChildren().clear();
        //移除之前的记录
        ObservableList<Node> observableList = guanliPane.getChildren();
        guanliPane.getChildren().remove(observableList);
        for (GuanLi guanli : guanliList) {
            VBox vBox1 = new VBox();
            vBox1.setSpacing(30);
            Button button1 = new Button(guanli.getName());
            button1.getStyleClass().add("button-blue");
            vBox1.getChildren().add(button1);
            //按钮点击显示管理员信息
            button1.setOnAction(event -> {
                HBox hBox = new HBox();
                //设置个人水平盒子
                hBox.setPrefSize(340, 260);
                //设置内边距
                hBox.setSpacing(25);
                hBox.setPadding(new Insets(20, 20, 20, 20));
                //美化水平盒子  调用css中的box
                hBox.getStyleClass().add("box");
                //创建左侧的垂直布局
                VBox leftBox = new VBox();
                leftBox.setSpacing(10);
                //对齐方式
                leftBox.setAlignment(Pos.CENTER);
                //头像图片
                Image image = new Image(guanli.getPicture());
                ImageView pictureImg = new ImageView(image);
                pictureImg.setFitWidth(100);
                pictureImg.setFitHeight(100);
                //给头像设置圆形效果
                Circle circle = new Circle();
                circle.setCenterY(50);
                circle.setCenterX(50);
                circle.setRadius(40);
                pictureImg.setClip(circle);
                //头像加入左边盒子
                leftBox.getChildren().add(pictureImg);
                hBox.getChildren().add(leftBox);
                //创建中间垂直盒子
                VBox centerBox = new VBox();
                centerBox.setSpacing(10);
                centerBox.setAlignment(Pos.TOP_LEFT);
                Label mingzilabel = new Label("姓名：");
                Label xblabel = new Label("性别:");
                Label xllabel = new Label("学历:");
                Label dianhualabel = new Label("电话:");
                mingzilabel.getStyleClass().add("label-small-black");
                xblabel.getStyleClass().add("label-small-black");
                xllabel.getStyleClass().add("label-small-black");
                dianhualabel.getStyleClass().add("label-small-black");
                centerBox.getChildren().addAll(mingzilabel, xblabel, xllabel, dianhualabel);
                hBox.getChildren().add(centerBox);
                //创建右边垂直布局盒子
                VBox rightBox = new VBox();
                rightBox.setSpacing(10);
                rightBox.setAlignment(Pos.TOP_LEFT);
                Label namelabel = new Label(guanli.getName());//管理员名字
                Label xinbielabel = new Label(guanli.getXinbie());//管理员性别
                Label xuelilabel = new Label(guanli.getXueli());//管理员学历
                Label mobilelabel = new Label(guanli.getMobile());//管理员电话
                namelabel.getStyleClass().add("label-small-black");
                xinbielabel.getStyleClass().add("label-small-black");
                xuelilabel.getStyleClass().add("label-small-black");
                mobilelabel.getStyleClass().add("label-small-black");
                Button button = new Button("删除");
                button.getStyleClass().add("warning-theme");
                //点击删除按钮要做的事情
                button.setOnAction(event1 -> {
                    //1弹出一个确认的对话框
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setContentText("确定删除该管理员信息吗？");
                    //2点击了“确认”按钮
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        //得到个人的id
                        long id = guanli.getId();
                        //调用readerDAO的删除方法
                        guanliService.deleteGuanLi(id);
                        //从流式面板里面删除掉
                        guanliPane.getChildren().remove(hBox);
                    }
                });
                rightBox.getChildren().addAll(namelabel, xinbielabel, xuelilabel, mobilelabel, button);
                hBox.getChildren().add(rightBox);
                guanliPane.getChildren().add(hBox);
            });
            guanliPane.getChildren().add(vBox1);
        }
    }
    public void addGuanLi() {
        GuanLi guanLi = new GuanLi();
        //新建一个舞台
        Stage stage = new Stage();
        stage.setTitle("新增会员界面");
        //创建一个垂直布局，用来放新增用户的各个组件
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        vBox.setPadding(new Insets(20, 10, 10, 10));
        vBox.setAlignment(Pos.CENTER);
        TextField nameField = new TextField("请输入姓名");
        TextField xinbieField = new TextField("新增管理员的性别");
        TextField pictureField = new TextField("请输入头像地址");
        TextField xueliField = new TextField("新增管理员的学历");
        TextField mobileField = new TextField("请输入手机号码");
        Button addBtn = new Button("确认新增");
        addBtn.getStyleClass().add("warm-theme");
        vBox.getChildren().addAll(nameField, xinbieField, pictureField, xueliField, mobileField, addBtn);
        Scene scene = new Scene(vBox, 540, 450);
        stage.setScene(scene);
        stage.show();
        //点击新增按钮，将界面数据封装成一个Guanli对象，写入数据库
        addBtn.setOnAction(event -> {
            String nameString = nameField.getText().trim();
            String xinbieString = xinbieField.getText().trim();
            String pictureString = pictureField.getText().trim();
            String xueliString = xueliField.getText().trim();
            String mobileString = mobileField.getText().trim();
            guanLi.setName(nameString);
            guanLi.setXinbie(xinbieString);
            guanLi.setPicture(pictureString);
            guanLi.setXueli(xueliString);
            guanLi.setMobile(mobileString);
            System.out.println(guanLi.getName() + guanLi.getXinbie() + guanLi.getPicture() + guanLi.getXueli() + guanLi.getMobile());
            guanliService.addGuanLi(guanLi);
            stage.close();
            guanliList = guanliService.getAllGuanLis();
            showGuanLi(guanliList);
        });
    }
}