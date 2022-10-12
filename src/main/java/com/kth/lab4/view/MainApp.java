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

    private MenuBar menuBar;

    @Override
    public void start(Stage primaryStage) {

        imageView = new ImageView();

        createMenuBar();
        menuBar = getMenuBar();
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
        EventHandler<ActionEvent> exitHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0); // save data?
            }
        };
        exitItem.addEventHandler(ActionEvent.ACTION, exitHandler);
        fileMenu.getItems().add(exitItem);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
    }

    public MenuBar getMenuBar(){
        return this.menuBar;
    }
}
