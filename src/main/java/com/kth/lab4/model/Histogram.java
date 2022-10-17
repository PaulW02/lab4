package com.kth.lab4.model;

public class Histogram {


    /**
     * Takes the 2D matrix of the image and calculates the data for the histogram and returns it.
     * @param imageData the 2D data of the image that is to be calculated.
     * @return the calculated data of the histogram to be shown.
     */
    public int[][] calculateHistogram(int[][] imageData){
        int[][] histogramData = new int[3][256];
        int color, rValue, gValue, bValue;
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[0].length; j++) {
                color = imageData[i][j];
                rValue = ((color >> 16) & 0xff);
                gValue = ((color >> 8) & 0xff);
                bValue = ((color) & 0xff);

                histogramData[0][rValue]++;
                histogramData[1][gValue]++;
                histogramData[2][bValue]++;
            }
        }
        return histogramData;
    }

}
