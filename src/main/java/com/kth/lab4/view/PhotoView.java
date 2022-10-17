package com.kth.lab4.view;
import com.kth.lab4.controller.ImageController;
import com.kth.lab4.io.FileIO;
import com.kth.lab4.model.exceptions.IllegalImageFormatException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    private Stage stage;

    private BorderPane borderPane;

    private final Alert alert = new Alert(Alert.AlertType.WARNING, "Something went wrong, check if the image has the correct format (.png)", ButtonType.OK);

    public PhotoView(Stage stage, BorderPane borderPane)  {
        super();
        this.stage = stage;
        this.borderPane = borderPane;
        this.imageView = new ImageView();
        createUIComponents();
    }

    public void createUIComponents(){
        Button loadButton = new Button("Load image");
        loadButton.setOnAction(event -> openAndLoadImage());
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setPadding(new Insets(5));
        pane.getChildren().add(loadButton);
        borderPane.setBottom(pane);
    }

    private void openAndLoadImage() {
        try {
            Image image = FileIO.openAndLoadImage(stage);
            imageView.setImage(image);
            borderPane.setCenter(imageView);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
        }catch (IllegalImageFormatException e){
            alert.showAndWait();
        }
    }

}
