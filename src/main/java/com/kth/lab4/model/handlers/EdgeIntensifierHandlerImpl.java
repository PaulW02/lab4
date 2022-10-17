package com.kth.lab4.model.handlers;

import static java.lang.Math.floor;

public class EdgeIntensifierHandlerImpl implements IImageHandler{
    @Override
    public int[][] processImage(int[][] originalImg) {
        int rows = originalImg.length;
        int cols = originalImg[0].length;
        int[][] blurredImageMatrix = new int[rows-2][cols-2];
        for (int r=1; r < rows-1; r++) {
            for (int c=1; c < cols-1; c++){
                blurredImageMatrix[r-1][c-1] = calculateAlgorithm(originalImg, r, c);
            }
        }

        return blurredImageMatrix;
    }

    private int calculateAlgorithm(int[][] image, int r, int c) {
        return (image[r-1][c-1] * 0) + (image[r-1][c] * 1) + (image[r-1][c+1] * 0) +
                (image[r][c-1] * 1) + (image[r][c] * -4) + (image[r][c+1] * 1) +
                (image[r+1][c-1] * 0) + (image[r+1][c] * 1) + (image[r+1][c+1] * 0);
    }
}
