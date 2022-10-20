package com.kth.lab4;
import com.kth.lab4.controller.ImageController;
import com.kth.lab4.io.FileIO;
import com.kth.lab4.model.Histogram;
import com.kth.lab4.view.*;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainApp extends Application{

    private PhotoView photoView;
    private Stage stage;
    private BorderPane root;
    private MenuBar menuBar;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        root = new BorderPane();
        createMenuBar();
        root.setTop(menuBar);
        photoView = new PhotoView(primaryStage, root);
        root.setCenter(photoView);
        // we need a VBox to put the menu bar at the top of the window
        Scene scene = new Scene(root, 650,650);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("PhotoEditor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createMenuBar(){
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem newFileItem = new MenuItem("New File");
        MenuItem saveFileItem = new MenuItem("Save File");

        Menu photoOptions = new Menu("Generate");
        MenuItem histogramItem = new MenuItem("Histogram");
        MenuItem contrastItem = new MenuItem("Contrast");
        MenuItem blurItem = new MenuItem("Blur");
        MenuItem invertColorsItem = new MenuItem("Invert Colors");
        MenuItem edgeIntensifierItem = new MenuItem("Intensify Edges");

        Alert alert = new Alert(Alert.AlertType.WARNING, "Choose an image first!", ButtonType.OK);

        EventHandler<ActionEvent> exitHandler = actionEvent -> {
            System.exit(0); // save data?
        };
        exitItem.addEventHandler(ActionEvent.ACTION, exitHandler);

        EventHandler<ActionEvent> newFileHandler = actionEvent -> start(stage);
        newFileItem.addEventHandler(ActionEvent.ACTION,newFileHandler);

        EventHandler<ActionEvent> saveFileHandler = actionEvent -> {
            try{
                Image image = ((ImageView) root.getCenter()).getImage();
                FileIO.saveImage(image);
            }catch (ClassCastException e){
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        saveFileItem.addEventHandler(ActionEvent.ACTION,saveFileHandler);

        EventHandler<ActionEvent> contrastHandler = actionEvent -> {
            try{
                new ContrastView(root, ((ImageView) root.getCenter()).getImage());
            }catch (ClassCastException e){
                alert.showAndWait();
            }
        };
        contrastItem.addEventHandler(ActionEvent.ACTION,contrastHandler);

        EventHandler<ActionEvent> histogramHandler = actionEvent -> {
            try{
                new HistogramView(root, ((ImageView) root.getCenter()).getImage());
            }catch (ClassCastException e){
                alert.showAndWait();
            }
        };
        histogramItem.addEventHandler(ActionEvent.ACTION,histogramHandler);

        EventHandler<ActionEvent> blurImageHandler = actionEvent -> {
            try{
                new BlurImageView(root, ((ImageView) root.getCenter()).getImage());
            }catch (ClassCastException e){
                alert.showAndWait();
            }
        };
        blurItem.addEventHandler(ActionEvent.ACTION,blurImageHandler);

        EventHandler<ActionEvent> invertColorsHandler = actionEvent -> {
            try{
                new InvertColorView(root, ((ImageView) root.getCenter()).getImage());
            }catch (ClassCastException e){
                alert.showAndWait();
            }
        };
        invertColorsItem.addEventHandler(ActionEvent.ACTION,invertColorsHandler);

        EventHandler<ActionEvent> edgeIntensifierHandler = actionEvent -> {
            try{
                new EdgeIntensifierView(root, ((ImageView) root.getCenter()).getImage());
            }catch (ClassCastException e){
                alert.showAndWait();
            }
        };
        edgeIntensifierItem.addEventHandler(ActionEvent.ACTION,edgeIntensifierHandler);


        fileMenu.getItems().addAll(exitItem,newFileItem, saveFileItem);
        photoOptions.getItems().addAll(histogramItem, contrastItem, blurItem, invertColorsItem, edgeIntensifierItem);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, photoOptions);
    }

}
