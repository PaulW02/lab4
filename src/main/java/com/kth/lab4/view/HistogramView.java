package com.kth.lab4.view;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistogramView {

    public void createChart(Stage primaryStage, Image image, int[][] histogramData, MenuBar menuBar) {

        ImageView imageView = new ImageView();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> chartHistogram
                = new LineChart<>(xAxis, yAxis);
        chartHistogram.setCreateSymbols(false);

        imageView.setImage(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        chartHistogram.getData().clear();

        XYChart.Series seriesAlpha = new XYChart.Series();
        XYChart.Series seriesRed = new XYChart.Series();
        XYChart.Series seriesGreen = new XYChart.Series();
        XYChart.Series seriesBlue = new XYChart.Series();
        seriesAlpha.setName("alpha");
        seriesRed.setName("red");
        seriesGreen.setName("green");
        seriesBlue.setName("blue");

        for (int i = 0; i < 256; i++) {
            seriesAlpha.getData().add(new XYChart.Data(String.valueOf(i), histogramData[0][i]));
            seriesRed.getData().add(new XYChart.Data(String.valueOf(i), histogramData[1][i]));
            seriesGreen.getData().add(new XYChart.Data(String.valueOf(i), histogramData[2][i]));
            seriesBlue.getData().add(new XYChart.Data(String.valueOf(i), histogramData[3][i]));
        }

        chartHistogram.getData().addAll(
                //imageHistogram.getSeriesAlpha(),
                seriesRed, seriesGreen, seriesBlue);
        chartHistogram.setMaxWidth(400);
        chartHistogram.setMaxHeight(400);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(imageView, chartHistogram);

        VBox vBox = new VBox(menuBar);
        vBox.getChildren().addAll(hBox);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
