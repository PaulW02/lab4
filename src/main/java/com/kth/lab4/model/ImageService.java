package com.kth.lab4.model;

import com.kth.lab4.model.handlers.IImageHandler;

public class ImageService {
    private int[][] matrix;

    public ImageService(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] handleImage(IImageHandler handler){
        this.matrix = handler.processImage(matrix);
        return this.matrix;
    }

    public int[][] createHistogram(int[][] imageData){
        return new int[0][];
    }
}
