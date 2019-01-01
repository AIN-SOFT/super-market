package com.soft1841.sm.controller;

import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 后台登陆界面
 * @auther 徐鹏
 * 2018年12月24日
 */
public class LoginController {
    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;
    //退出系统
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private void close(){
        Stage closeStage = (Stage) closeButton.getScene().getWindow();
        closeStage.close();
    }
    private SellerService sellerService = ServiceFactory.getSellerServiceInstance();

    public void login() throws Exception {
      String account = accountField.getText().trim();
        String password = passwordField.getText().trim();
        //调用service的登录功能
        boolean flag = sellerService.login(account, password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");

        if (flag) {
            alert.setContentText("恭喜你登录成功!");
            alert.showAndWait();
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            BorderPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/style.css");
            mainStage.setTitle("超市收银系统");
            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
            Stage loginStage = (Stage) accountField.getScene().getWindow();
            loginStage.close();
        } else {
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
    }

    public void login_Enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void login(ActionEvent event) {
        try {
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
