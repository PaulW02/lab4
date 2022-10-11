package com.kth.lab4.view;

import com.kth.lab4.controller.ImageController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LoadImageIntoImageViewWithFileChooser extends Application {

    private ImageView imageView;
    private FileChooser fileChooser;
    private ImageController imageController;

    @Override
    public void start(Stage primaryStage) {

        imageView = new ImageView();
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(
                        "png files", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open Image File");

        Button loadButton = new Button("Load image");
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openAndLoadImage(primaryStage);
            }
        });

        // ui stuff ...
        BorderPane root = new BorderPane();
        root.setCenter(imageView);
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(5,5,5,5));
        bottomPane.getChildren().add(loadButton);
        root.setBottom(bottomPane);

        Scene scene = new Scene(root, 400, 400);
        scene.setFill(Color.WHITE);

        primaryStage.setTitle("ImageView example");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private void openAndLoadImage(Stage stage) {

        File file = fileChooser.showOpenDialog(stage);

        // now, load the image
        if(file != null) {
            Image image = new Image(file.toURI().toString());
            int[][] matrix = new int[(int) image.getWidth()][(int) image.getHeight()];
            imageView.setImage(image);
            for (int i = 0; i < image.getWidth(); i++){
                for (int j = 0; j < image.getHeight(); j++){
                    matrix[i][j] = image.getPixelReader().getArgb(i,j);
                }
            }
            imageController = new ImageController(matrix);
            MenuView menuView = new MenuView(imageController, imageView);
            menuView.start(stage);

            // this will scale the image/image view to fit its container (pane)
            imageView.fitWidthProperty().bind(stage.widthProperty());
            imageView.setPreserveRatio(true);

            imageView.setSmooth(true);

            // exception handling needed?
        }
        else {
            // show an Alert
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
