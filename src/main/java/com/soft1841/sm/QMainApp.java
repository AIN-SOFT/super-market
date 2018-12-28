package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 前台主界面App
 */
public class QMainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("超市前台收银系统");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/qmain.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,700);
//        primaryStage.setMaximized(true);
        scene.getStylesheets().add(MainApp.class.getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
