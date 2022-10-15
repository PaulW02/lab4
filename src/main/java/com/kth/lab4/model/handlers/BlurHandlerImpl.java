package com.kth.lab4.model.handlers;

import java.awt.Color;

public class BlurHandlerImpl implements IImageHandler{
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
    private int getAverage(int[][] image, int r, int c) {
        return (image[r-1][c-1] + image[r-1][c] + image[r-1][c+1] +
                image[r][c-1] + image[r][c] + image[r][c+1] +
                image[r+1][c-1] + image[r+1][c] + image[r+1][c+1]) / 9;
    }
}
