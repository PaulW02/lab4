package com.kth.lab4.model.handlers;

import java.awt.Color;

public class BlurHandlerImpl implements IImageHandler{

    /**
     * Takes a 2D matrix and uses an algorithm that takes the different colors of each pixels in the matrix and
     * smoothes each one of them, and then returns the blurred matrix.
     * @param originalImg gets the 2D matrix of the original image
     * @return the matrix that has been blurred.
     */
    @Override
    public int[][] processImage(int[][] originalImg) {
        int rows = originalImg.length;
        int cols = originalImg[0].length;
        Color color;
        int[][] blurredImageMatrix = new int[rows][cols];
        int[][] red = new int[rows][cols];
        int[][] green = new int[rows][cols];
        int[][] blue = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                color = new Color(originalImg[i][j]);
                red[i][j] = color.getRed();
                green[i][j] = color.getGreen();
                blue[i][j] = color.getBlue();
            }
        }

        for (int r=1; r < rows-1; r++) {
            for (int c=1; c < cols-1; c++){
                red[r][c] = getAverage(red, r, c);
                green[r][c] = getAverage(green, r, c);
                blue[r][c] = getAverage(blue, r, c);
                color = new Color(red[r][c], green[r][c], blue[r][c]);
                blurredImageMatrix[r][c] = color.getRGB();
            }
        }
        return blurredImageMatrix;
    }

    /**
     * Takes an image and a specific row and column and returns the average value of the neighboring pixels including the current pixel.
     * @param image the matrix of the image to be used.
     * @param r the specific row.
     * @param c the specific column.
     * @return returns the average value of the neighboring pixels including the current pixel.
     */
    private int getAverage(int[][] image, int r, int c) {
        return (image[r-1][c-1] + image[r-1][c] + image[r-1][c+1] +
                image[r][c-1] + image[r][c] + image[r][c+1] +
                image[r+1][c-1] + image[r+1][c] + image[r+1][c+1]) / 9;
    }
}
