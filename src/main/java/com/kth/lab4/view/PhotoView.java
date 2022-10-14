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
    private FileChooser fileChooser;

    private Stage stage;

    private BorderPane borderPane;


    public PhotoView(Stage stage, BorderPane borderPane) {
        super();
        this.stage = stage;
        this.borderPane = borderPane;
        createUiComponents();
    }

    private void createUiComponents(){
        imageView = new ImageView();
        fileChooser = new FileChooser();
        Button loadButton = new Button("Load image");

        loadButton.setOnAction(event -> openAndLoadImage());

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setPadding(new Insets(5));
        pane.getChildren().add(loadButton);
        borderPane.setBottom(pane);
    }

    private void openAndLoadImage() {

        File file = fileChooser.showOpenDialog(stage);

        // now, load the image
        if(file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
            borderPane.setCenter(imageView);
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
