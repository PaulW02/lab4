package com.kth.lab4.view;

import com.kth.lab4.controller.ImageController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MenuView extends Application{

    private ImageController imageController;
    private ImageView imageView;
    public MenuView(ImageController imageController, ImageView imageView) {
        this.imageController = imageController;
        this.imageView = imageView;

    }

    @Override
    public void start(Stage primaryStage) {

        Button blurImageBtn = new Button("Blur image");
        blurImageBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WritableImage writableImage = new WritableImage(imageView.getImage().getPixelReader(), (int) imageView.getImage().getWidth(), (int) imageView.getImage().getHeight());
                int[][] blurredImageMatrix = imageController.blurImage();
                for (int i = 0; i < blurredImageMatrix.length; i++){
                    for (int j = 0; j < blurredImageMatrix[0].length; j++){
                        writableImage.getPixelWriter().setArgb(i,j, blurredImageMatrix[i][j]);
                    }
                }
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
                imageController.intensifyImageEdges();
            }
        });

        // ui stuff ...
        BorderPane root = new BorderPane();
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(5,5,5,5));
        bottomPane.getChildren().add(blurImageBtn);
        bottomPane.getChildren().add(invertColorsBtn);
        bottomPane.getChildren().add(edgeIntensifierBtn);
        bottomPane.getChildren().add(contrastBtn);
        root.setBottom(bottomPane);
        root.setCenter(imageView);
        Scene scene = new Scene(root, 400, 400);
        scene.setFill(Color.WHITE);
        primaryStage.setTitle("ImageView example");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

    }



    public static void main(String[] args) {
        launch(args);
    }

}
