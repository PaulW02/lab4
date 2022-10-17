package com.kth.lab4.model.handlers;

public class EdgeIntensifierHandlerImpl implements IImageHandler{

    /**
     * Takes the 2D matrix and returns a new 2D edge intensified matrix.
     * @param originalImg gets the 2D matrix of the original image.
     * @return a new 2D edge intensified matrix
     */
    @Override
    public int[][] processImage(int[][] originalImg) {
        int rows = originalImg.length;
        int cols = originalImg[0].length;
        int[][] edgeIntensifiedMatrix = new int[rows-2][cols-2];
        for (int r=1; r < rows-1; r++) {
            for (int c=1; c < cols-1; c++){
                edgeIntensifiedMatrix[r-1][c-1] = calculateAlgorithm(originalImg, r, c);
            }
        }
        return edgeIntensifiedMatrix;
    }

    /**
     * Takes an image and a specific row and column and returns the value of the neighboring pixels including the current pixel using the algorithm for edge intensifying.
     * @param image the matrix of the image to be used.
     * @param r the specific row.
     * @param c the specific column.
     * @return returns the value of the neighboring pixels including the current pixel through the edge intensifier algorithm.
     */
    private int calculateAlgorithm(int[][] image, int r, int c) {
        return (image[r-1][c-1] * 0) + (image[r-1][c] * 1) + (image[r-1][c+1] * 0) +
                (image[r][c-1] * 1) + (image[r][c] * -4) + (image[r][c+1] * 1) +
                (image[r+1][c-1] * 0) + (image[r+1][c] * 1) + (image[r+1][c+1] * 0);
    }
}
