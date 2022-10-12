package com.kth.lab4.model.handlers;

import javafx.scene.paint.Color;

public class InvertColorHandlerImpl implements IImageHandler{
    @Override
    public int[][] processImage(int[][] originalImg) {
        int[][] invertColorsMatrix = new int[originalImg.length][originalImg[0].length];
        int aValue, rValue, gValue, bValue, color;
        for (int i = 0; i < originalImg.length; i++) {
            for (int j = 0; j < originalImg[0].length; j++) {
                color = originalImg[i][j];
                aValue = ((color >> 24) & 0xff);
                rValue = ((color >> 16) & 0xff);
                gValue = ((color >> 8) & 0xff);
                bValue = ((color) & 0xff);

                Color invertedColor = new Color((double)rValue/255, (double)gValue/255, (double)bValue/255, (double) aValue/255);
                invertedColor = invertedColor.invert();
                //invertColorsMatrix[i][j] = ((int)invertedColor.getOpacity()*255 << 24) | ((int)invertedColor.getRed()*255 << 16) | ((int)invertedColor.getGreen()*255 << 8) | (int)invertedColor.getBlue()*255;
                invertColorsMatrix[i][j] = (int)invertedColor.getOpacity()*255;
                System.out.println(invertedColor);
                invertColorsMatrix[i][j] = (invertColorsMatrix[i][j] << 8) + (int)invertedColor.getRed()*255;
                invertColorsMatrix[i][j] = (invertColorsMatrix[i][j] << 8) + (int)invertedColor.getGreen()*255;
                invertColorsMatrix[i][j] = (invertColorsMatrix[i][j] << 8) + (int)invertedColor.getBlue()*255;
                System.out.println();
            }
        }
        return  invertColorsMatrix;
    }
}
