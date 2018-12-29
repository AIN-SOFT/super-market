package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Good;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**  @auther 许源
 * 新增商品控制台
 */
public class AddGoodController implements Initializable {
    private ObservableList<Good> goodsData = FXCollections.observableArrayList();
    public ObservableList<Good> getGoodsData() {
        return goodsData;
    }
    public void setGoodData(ObservableList<Good> goodsData) {
        this.goodsData = goodsData;
    }
    @FXML
    private ComboBox<Type> goodType;
    @FXML
    private TextField goodName,  goodPrice, goodCover,  goodStock  ;
    @FXML
    private TextArea goodSummary;
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private GoodService goodService = ServiceFactory.getGoodsServiceInstance();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private List<Type> typeList = null;
    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeList = typeService.getAllTypes();
        typeData.addAll(typeList);
        goodType.setItems(typeData);
        goodType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    typeId = newValue.getId();
                }
        );
    }

    public void addGoods() {
        String name =   goodName.getText();
        String price = goodPrice.getText();
        String stock = goodStock.getText();
        String cover = goodCover.getText();
        String summary =goodSummary.getText();
        System.out.println(stock);
        Good good = new Good ();
        good.setTypeId(typeId);
        good.setName(name);
        good.setPrice(Double.parseDouble(price));
        good.setStock(Integer.parseInt(stock));
        good.setCover(cover);
        good.setSummary(summary);
        long id = goodService.addGoods(good);
        good.setId(id);
        this.getGoodsData().add(good);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增商品成功!");
        alert.showAndWait();
        Stage stage = (Stage) goodName.getScene().getWindow();
        stage.close();
    }
}