package com.kth.lab4.view;

import com.kth.lab4.controller.ImageController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EdgeIntensifierView {
    private BorderPane borderPane;
    private Button edgeIntensifierBtn;
    private ImageView imageView;

    public EdgeIntensifierView(BorderPane borderPane, Image image) {
        this.borderPane = borderPane;
        this.imageView = new ImageView(image);
        createUIComponents();
        ImageController imageController = new ImageController(image);
        addEventHandlers(imageController);
    }

    public void createUIComponents() {
        edgeIntensifierBtn = new Button("Intensify edges");
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        borderPane.setCenter(imageView);
        VBox vBox = new VBox(edgeIntensifierBtn);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setPadding(new Insets(5));
        borderPane.setBottom(vBox);
    }

    private void addEventHandlers(ImageController controller) {
        edgeIntensifierBtn.setOnAction((ActionEvent event) -> imageView.setImage(controller.intensifyImageEdges()));
    }
}
