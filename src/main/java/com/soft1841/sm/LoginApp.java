package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("超市收银系统 ");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.getIcons().add(new Image("/img/001.jpg"));
        Scene scene = new Scene(root, 790, 520);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
