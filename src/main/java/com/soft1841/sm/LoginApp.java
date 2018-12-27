package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 后台登陆主程序
 * @auther 徐鹏
 * 2018年12月24日
 */
public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("超市后台管理系统 ");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.getIcons().add(new Image("/img/001.jpg"));
        Scene scene = new Scene(root, 960, 590);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
