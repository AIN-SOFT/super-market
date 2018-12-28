package com.soft1841.sm.controller;

import com.soft1841.sm.service.QianTaiService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 前台登陆界面
 * @auther 徐鹏
 * 2018年12月25日
 */
public class QLoginController {
    @FXML
    private TextField accountField;

    @FXML
    private PasswordField passwordField;

    //新增001
    private QianTaiService qianTaiService = ServiceFactory.getQianTaiServiceInstance();

    public void qiantailogin()throws Exception {
        String account =accountField.getText().trim();
        String password = passwordField.getText().trim();

        //调用service的登录功能
        boolean flag1 = qianTaiService.qiantailogin(account,password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");

        if(flag1){
            alert.setContentText("恭喜你登录成功!");
            alert.showAndWait();
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/qmain.fxml"));
            AnchorPane  root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/style.css");
            mainStage.setTitle("超市前台收银系统");
//            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
            Stage loginStage = (Stage) accountField.getScene().getWindow();
            loginStage.close();
        }else {
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
    }
}
