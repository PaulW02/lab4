package com.kth.lab4.model.handlers;

public interface IImageHandler {

    /**
     * @param originalImg a 2D matrix of the original image
     * @return a new processed 2D matrix
     */
    public abstract int[][] processImage(int[][] originalImg);

}
