package com.kth.lab4.view;

import com.kth.lab4.controller.ImageController;
import com.kth.lab4.model.Histogram;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuView extends BorderPane{

    private ImageController imageController;
    private ImageView imageView;

    private Stage stage;

    private MenuBar menuBar;
    public MenuView(Stage stage, ImageController imageController, ImageView imageView, MenuBar menuBar) {
        this.stage = stage;
        this.imageController = imageController;
        this.imageView = imageView;
        this.menuBar = menuBar;
        createUiComponents();
    }

    private void createUiComponents(){
        VBox root = new VBox(menuBar, this);
        Scene scene = new Scene(root, 400, 400);
        scene.setFill(Color.WHITE);

        Button blurImageBtn = new Button("Blur image");

        blurImageBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int[][] blurredImageMatrix = imageController.blurImage();
                WritableImage writableImage = (WritableImage) ImagePixelMatrixConverter.getImage(blurredImageMatrix);
                imageView.setImage(writableImage);
            }
        });

        Button invertColorsBtn = new Button("Invert colors");
        invertColorsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imageController.invertImageColors();
            }
        });

        Button contrastBtn = new Button("Change contrast");
        contrastBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image image = new Image(this.getClass().getResource("/images/devil.png").toString());
                imageView.setImage(image);
                imageController.changeImageContrast();
            }
        });

        Button edgeIntensifierBtn = new Button("Intensify edges");
        edgeIntensifierBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WritableImage writableImage = (WritableImage) ImagePixelMatrixConverter.getImage(imageController.intensifyImageEdges());
                imageView.setImage(writableImage);
            }
        });

        Button histogramBtn = new Button("Create histogram");
        histogramBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HistogramView histogramView = new HistogramView();
                histogramView.createChart(stage, imageView.getImage(), imageController.handleHistogramSelected());
            }
        });

        stage.setScene(scene);
        // ui stuff ...
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setPadding(new Insets(5));
        pane.getChildren().addAll(blurImageBtn, contrastBtn, invertColorsBtn, edgeIntensifierBtn, histogramBtn, imageView);

        this.setCenter(imageView);
        this.setBottom(pane);
        stage.show();
    }


}

