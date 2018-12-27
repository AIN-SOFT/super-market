package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 前台登陆主程序
 * 2018年12月25日
 */

public class QLoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("超市前台收银系统 ");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/qlogin.fxml"));
        primaryStage.getIcons().add(new Image("/img/001.jpg"));
        Scene scene = new Scene(root, 960, 600);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

