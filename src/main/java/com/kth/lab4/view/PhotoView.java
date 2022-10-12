package com.kth.lab4.view;
import com.kth.lab4.controller.ImageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PhotoView extends BorderPane{

    private ImageView imageView;
    private MenuBar menuBar;
    private FileChooser fileChooser;
    private ImageController imageController;

    private MenuView menuView;

    private Stage stage;


    public PhotoView(Stage stage, MenuBar menuBar) {
        super();
        this.stage = stage;
        this.menuBar = menuBar;
        createUiComponents();
    }

    private void createUiComponents(){
        imageView = new ImageView();
        fileChooser = new FileChooser();
        Button loadButton = new Button("Load image");

        Scene scene = new Scene(this, 400, 400);
        scene.setFill(Color.WHITE);
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openAndLoadImage();
            }
        });

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setPadding(new Insets(5));
        pane.getChildren().add(loadButton);
        this.setBottom(pane);
    }

    private void openAndLoadImage() {

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
            menuView = new MenuView(stage, imageController, imageView, menuBar);

            // this will scale the image/image view to fit its container (pane)
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);

            imageView.setSmooth(true);

            // exception handling needed?
        }
        else {
            // show an Alert
        }
    }
}
