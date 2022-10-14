package com.kth.lab4.view;
import com.kth.lab4.controller.ImageController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application{

    private ImageView imageView;
    private PhotoView photoView;
    private Stage stage;
    private MenuBar menuBar;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        imageView = new ImageView();
        menuBar = getMenuBar();
        createMenuBar();
        photoView = new PhotoView(primaryStage, menuBar);
        // we need a VBox to put the menu bar at the top of the window

        VBox root = new VBox(menuBar,photoView);
        Scene scene = new Scene(root, 400,400);
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
        EventHandler<ActionEvent> exitHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0); // save data?

            }
        };
        exitItem.addEventHandler(ActionEvent.ACTION, exitHandler);
        EventHandler<ActionEvent> newFileHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                start(stage);
            }
        };
        newFileItem.addEventHandler(ActionEvent.ACTION,newFileHandler);
        fileMenu.getItems().addAll(exitItem,newFileItem);

        /*


        Menu generateMenu = new Menu("Generate");
        MenuItem menuItem1 = new MenuItem("Intensify");
        
        MenuItem menuItem2 = new MenuItem("contrast");
        MenuItem menuItem3 = new MenuItem("invert");

        EventHandler<ActionEvent> invertColorsBtn = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageController.invertImageColors();
            }
        };
        menuItem3.addEventHandler(ActionEvent.ACTION, invertColorsBtn);

        generateMenu.getItems().addAll(menuItem1,menuItem2,menuItem3);
        menuBar.getMenus().addAll(generateMenu);*/

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

    }

    public MenuBar getMenuBar(){
        return this.menuBar;
    }
}
