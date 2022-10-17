package com.kth.lab4.model.handlers;

import java.awt.Color;

public class InvertColorHandlerImpl implements IImageHandler{

    /**
     * @param originalImg the 2D matrix of the original image
     * @return a new 2D matrix with the colors being inverted
     */
    @Override
    public int[][] processImage(int[][] originalImg) {
        int[][] invertColorsMatrix = new int[originalImg.length][originalImg[0].length];
        for (int y = 0; y < originalImg[0].length; y++) {
            for (int x = 0; x < originalImg.length; x++) {
                int p = originalImg[x][y];
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                invertColorsMatrix[x][y] = p;
            }
        }
        return  invertColorsMatrix;
    }
}
