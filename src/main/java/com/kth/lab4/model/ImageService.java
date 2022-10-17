package com.kth.lab4.model;

import com.kth.lab4.model.handlers.IImageHandler;

public class ImageService {
    private int[][] matrix;

    public ImageService(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Gets a chosen handler and sets the matrix with the correct algorithm and returns the processed matrix.
     * @param handler the handler that has been chosen
     * @return the processed matrix
     */
    public int[][] handleImage(IImageHandler handler){
        this.matrix = handler.processImage(matrix);
        return this.matrix;
    }

    /**
     * creates a new histogram and returns the data for the histogram of an image.
     * @return the data for the histogram of the image.
     */
    public int[][] createHistogram(){
        Histogram histogram = new Histogram();
        return histogram.calculateHistogram(matrix);
    }
}
