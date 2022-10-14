package com.kth.lab4.view;
import com.kth.lab4.model.Histogram;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContrastView {


    public void createSlide(Stage primaryStage, Image image){
        ImageView imageView = new ImageView();

        imageView.setImage(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);

        Label lbl1 = new Label("Window: ");
        Label lbl2 = new Label("Level: ");

        Slider slider1 = new Slider(0, 255,0);
        Slider slider2 = new Slider(0, 255,0);
        slider1.setMaxWidth(300);
        slider2.setMaxWidth(300);
        slider1.setShowTickMarks(true);
        slider1.setShowTickLabels(true);
        slider1.setBlockIncrement(50);
        slider2.setShowTickMarks(true);
        slider2.setShowTickLabels(true);
        slider2.setBlockIncrement(50);

        VBox vBox = new VBox();
        vBox.getChildren().add(imageView);
        vBox.setAlignment(Pos.TOP_CENTER);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(lbl1,slider1,lbl2,slider2);
        vBox1.setAlignment(Pos.BOTTOM_CENTER);
        vBox1.setSpacing(10);

        StackPane root = new StackPane();
        root.getChildren().addAll(vBox,vBox1);
        Scene scene = new Scene(root,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
