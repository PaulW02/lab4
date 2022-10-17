package com.kth.lab4.model.handlers;

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
                int color = originalImg[x][y];
                int alpha = (color >> 24) & 0xff;
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = color & 0xff;

                // subtract RGB from 255
                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;

                // set new RGB value
                color = (alpha << 24) | (red << 16) | (green << 8) | blue;
                invertColorsMatrix[x][y] = color;
            }
        }
        return  invertColorsMatrix;
    }
}
