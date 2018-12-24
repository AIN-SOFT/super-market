package com.soft1841.sm.utils;

import javafx.scene.control.Button;

public class ComponentUtil {

    //根据传入的文字和主题返回一个按钮
    public static Button getButton(String text, String theme) {
        Button button = new Button(text);
        button.getStyleClass().add(theme);
        return button;
    }
}
