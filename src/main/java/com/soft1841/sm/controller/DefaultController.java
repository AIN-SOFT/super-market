package com.soft1841.sm.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DefaultController implements Initializable {

    //左边的轮播
    @FXML
    private ImageView goodImg;
    //轮播图资源数组
    String[] imgPath = {"shangpin1.jpg", "shangpin2.jpg", "shangpin3.jpg", "shangpin4.jpg", "shangpin5.jpg"};
   //右边的轮播
    @FXML
    private ImageView GetiImg;
    String[] imgPath1 = {"geti2.jpg",  "geti3.png", "geti1.jpg","geti4.jpg", "geti5.jpg"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath.length; i++) {
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                goodImg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();


        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath1.length; i++) {
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath1[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                GetiImg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath1.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();
    }
}
