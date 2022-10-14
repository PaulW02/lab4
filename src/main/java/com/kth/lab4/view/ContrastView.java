package com.kth.lab4.view;
import com.kth.lab4.controller.ImageController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContrastView implements IImageView{
    private BorderPane borderPane;
    private Button contrastBtn;
    private ImageView imageView;
    public ContrastView(BorderPane borderPane, Image image) {
        this.borderPane = borderPane;
        this.imageView = new ImageView(image);
        createUIComponents();
        ImageController imageController = new ImageController(image);
        createSlide(imageController);
    }

    @Override
    public void createUIComponents() {
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        borderPane.setCenter(imageView);
    }

    public void createSlide(ImageController controller){
        Label windowLbl = new Label("Window: ");
        Label levelLbl = new Label("Level: ");
        Slider windowSlider = new Slider(1, 255,0);
        Slider levelSlider = new Slider(1, 255,0);
        windowSlider.setMaxWidth(300);
        levelSlider.setMaxWidth(300);
        windowSlider.setShowTickMarks(true);
        windowSlider.setShowTickLabels(true);
        windowSlider.setBlockIncrement(50);
        levelSlider.setShowTickMarks(true);
        levelSlider.setShowTickLabels(true);
        levelSlider.setBlockIncrement(50);

        contrastBtn = new Button("Contrast");
        contrastBtn.setOnAction((ActionEvent event) -> imageView.setImage(ImagePixelMatrixConverter.getImage(controller.changeImageContrast((int) windowSlider.getValue(), (int) levelSlider.getValue()))));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(windowLbl,windowSlider,levelLbl,levelSlider, contrastBtn);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setPadding(new Insets(5));
        borderPane.setBottom(vBox);
    }


}
