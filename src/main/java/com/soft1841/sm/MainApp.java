package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 后台主界面App
 * @auther 徐鹏
 * 2018年12月24日
 */

public class MainApp extends Application {
    @Override    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("超市后台系统");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1200,1600);
        primaryStage.setMaximized(true);
        scene.getStylesheets().add(MainApp.class.getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}