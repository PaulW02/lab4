package com.kth.lab4.view;
import com.kth.lab4.controller.ImageController;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HistogramView implements IImageHandlerView {

    private final BorderPane borderPane;
    private final ImageView imageView;

    public HistogramView(BorderPane borderPane, Image image) {
        this.borderPane = borderPane;
        this.imageView = new ImageView(image);
        createUIComponents();
    }

    @Override
    public void createUIComponents() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(createChart(new ImageController(imageView.getImage()).handleHistogramSelected()));
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        borderPane.setCenter(imageView);
        borderPane.setBottom(vBox);
    }

    public LineChart createChart(int[][] histogramData) {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> chartHistogram
                = new LineChart<>(xAxis, yAxis);
        chartHistogram.setCreateSymbols(false);


        chartHistogram.getData().clear();

        XYChart.Series seriesRed = new XYChart.Series();
        XYChart.Series seriesGreen = new XYChart.Series();
        XYChart.Series seriesBlue = new XYChart.Series();

        seriesRed.setName("red");
        seriesGreen.setName("green");
        seriesBlue.setName("blue");

        for (int i = 0; i < 256; i++) {
            seriesRed.getData().add(new XYChart.Data(String.valueOf(i), histogramData[0][i]));
            seriesGreen.getData().add(new XYChart.Data(String.valueOf(i), histogramData[1][i]));
            seriesBlue.getData().add(new XYChart.Data(String.valueOf(i), histogramData[2][i]));
        }

        chartHistogram.getData().addAll(seriesRed, seriesGreen, seriesBlue);
        chartHistogram.setMaxWidth(350);
        chartHistogram.setMaxHeight(350);

        return chartHistogram;
    }

}
