package com.kth.lab4.model;

import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;

public class Histogram {

    private int[][] matrix;

    private XYChart.Series seriesAlpha;
    private XYChart.Series seriesRed;
    private XYChart.Series seriesGreen;
    private XYChart.Series seriesBlue;

    public Histogram(int[][] matrix) {
        this.matrix = matrix;
    }

    public Histogram(){}

    public int[][] calculateHistogram(){
        int[][] histogramData = new int[4][256];
        int color, aValue, rValue, gValue, bValue;
        Image image = ImagePixelMatrixConverter.getImage(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                color = matrix[i][j];
                aValue = ((color >> 24) & 0xff);
                rValue = ((color >> 16) & 0xff);
                gValue = ((color >> 8) & 0xff);
                bValue = ((color) & 0xff);

                histogramData[0][aValue]++;
                histogramData[1][rValue]++;
                histogramData[2][gValue]++;
                histogramData[3][bValue]++;
            }
        }

        return histogramData;
    }

}
