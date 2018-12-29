package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Good;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author 许源
 * 商品控制台
 */
public class GoodController implements Initializable {
    //布局文件中的表格视图对象，用来显示数据库中读取的所有商品信息
    @FXML
    private TableView<Good> goodTable;
    //布局文件中的下拉框组件对象，用来显示数据库中读取的所有商品种类
    @FXML
    private ComboBox<Type> typeComboBox;
    //布局文件中的输入文本框对象，用来输入搜索关键词
    @FXML
    private TextField keywordsField;
    //商品模型数据集合，可以实现相应数据的变化，无需刷新
    private ObservableList<Good> goodsDate = FXCollections.observableArrayList();
    //商品类型模型数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    //商品Service对象，从DAO工厂通过静态方法获得
    private GoodService goodService = ServiceFactory.getGoodsServiceInstance();
    //类别TypeService对象
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    //商品集合，存放数据库商品表各种查询的结果
    private List<Good> goodsList = null;
    //类别集合，存放数据库类别表查询结果
    private List<Type> typeList = null;
    //表格中的编辑列
    private TableColumn<Good, Good> editCol = new TableColumn<>("操作");
    //表格中的删除列
    private TableColumn<Good, Good> delCol = new TableColumn<>("操作");

    //初始化方法，通过调用对商品表格和列表下拉框的两个封装方法，实现数据初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
    }

    //表格初始化
    private void initTable() {
        //水平方向不显示滚动条，表格的列宽会均匀分布
        goodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //1.调用查询所有商品的方法，
        goodsList = goodService.getAllGoods();
        //将实体集合作为参数，调用显示数据的方法，可以在界面的表格中显示商品模型集合的值
        showGoodData(goodsList);
        //2.编辑列的相关设置
        editCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        editCol.setCellFactory(param -> new TableCell<Good, Good>() {
            //通过ComponentUtil工具类的静态方法，传入按钮文字和样式，获得一个按钮对象
            private final Button editButton = ComponentUtil.getButton("编辑", "blue-theme");

            @Override
            protected void updateItem(Good good, boolean empty) {
                super.updateItem(good, empty);
                if (good == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                //点击编辑按钮，弹出窗口，输入需要修改的商品价格
                editButton.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog("请输入价格");
                    dialog.setTitle("商品修改界面");
                    dialog.setHeaderText("商品名称：" + good.getName());
                    dialog.setContentText("请输入新的价格:");
                    Optional<String> result = dialog.showAndWait();
                    //确认输入了内容，避免NPE
                    if (result.isPresent()) {
                        //获取输入的新价格并转化成Double数据
                        String priceString = result.get();
                        good.setPrice(Double.parseDouble(priceString));
                        //更新商品信息
                        goodService.updateGood(good);
                    }
                });
            }
        });
        //将编辑列加入商品表格
        goodTable.getColumns().add(editCol);
        //3.删除列的相关设置
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Good, Good>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Good good, boolean empty) {
                super.updateItem(good, empty);
                if (good == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("商品名称 ：" + good.getName());
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        goodsDate.remove(good);
                        goodService.deleteGood(good.getId());
                    }
                });
            }
        });
        //将除列加入商品表格
        goodTable.getColumns().add(delCol);
        //4.商品表格双击事件,双击弹出显示商品详情的界面
        goodTable.setRowFactory(tv ->
        {
            TableRow<Good> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                //判断鼠标双击了一行
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //获得该行的商品ID属性
                    long id = row.getItem().getId();
                    //根据id查询到商品的完整信息
                    Good good = goodService.getGood(id);
                    //创建一个新的商品详情界面窗口
                    Stage goodInfoStage = new Stage();
                    goodInfoStage.setTitle("商品详情界面");
                    //用VBox显示具体商品信息
                    VBox vBox = new VBox();
                    vBox.setSpacing(20);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(0, 10, 0, 10));
                    Label nameLabel = new Label("        商品名称：\n" + good.getName());
                    nameLabel.getStyleClass().add("font-title");
                    Label priceLabel = new Label("价格:" + good.getPrice());
                    ImageView goodsImgView = new ImageView(new Image(good.getCover()));
                    goodsImgView.setFitHeight(150);
                    goodsImgView.setFitWidth(200);
                    Label summaryLabel = new Label(good.getSummary());
                    summaryLabel.setPrefWidth(200);
                    summaryLabel.setWrapText(true);
                    summaryLabel.getStyleClass().add("box");
                    vBox.getChildren().addAll(nameLabel, priceLabel, goodsImgView, summaryLabel);
                    Scene scene = new Scene(vBox, 640, 480);
                    //因为是一个新的窗口，需要重新读入一下样式表，这个界面就可以使用style.css样式表中的样式了
                    scene.getStylesheets().add("/css/manage.css");
                    goodInfoStage.setScene(scene);
                    goodInfoStage.show();
                }
            });
            return row;
        });
    }

    //下拉框初始化方法
    private void initComBox() {
        //1.到数据库查询所有的类别
        typeList = typeService.getAllTypes();
        //2.将typeList集合加入typeData模型数据集合
        typeData.addAll(typeList);
        //3.将数据模型设置给下拉框
        typeComboBox.setItems(typeData);
        //4.下拉框选择事件监听，根据选择不同的类别，商品表格中会过滤出该类别的商品
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    //移除掉之前的数据
                    goodTable.getItems().removeAll(goodsDate);
                    //根据选中的类别查询该类别所有商品
                    goodsList = goodService.getGoodsByTypeId(newValue.getId());
                    //重新显示数据
                    showGoodData(goodsList);
                }
        );
    }

    //显示商品表格数据的方法
    private void showGoodData(List<Good> goodsList) {
        goodsDate.addAll(goodsList);
        goodTable.setItems(goodsDate);
    }

    //弹出新增商品界面方法
    public void newGoodStage() throws Exception {
        Stage addGoodStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_good.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        AddGoodController addGoodController = fxmlLoader.getController();
        addGoodController.setGoodData(goodsDate);
        addGoodStage.setTitle("新增商品界面");
        //界面大小不可变
        addGoodStage.setResizable(false);
        addGoodStage.setScene(scene);
        addGoodStage.show();
    }

    //根据关键词搜索方法
    public void search() {
        goodTable.getItems().removeAll(goodsDate);
        //获得输入的查询关键字
        String keywords = keywordsField.getText().trim();
        goodsList = goodService.getGoodsLike(keywords);
        showGoodData(goodsList);
    }

//    //数据导出方法，采用hutoo提供的工具类
//    public void export() {
//        ExcelExport.export(goodsList);
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("提示信息");
//        alert.setHeaderText("商品数据已导出!请到F盘根目录查看!");
//        alert.showAndWait();
    //}
    }

