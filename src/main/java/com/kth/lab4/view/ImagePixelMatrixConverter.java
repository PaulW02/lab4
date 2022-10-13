package com.kth.lab4.view;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImagePixelMatrixConverter {

    public static int[][] getPixelMatrix(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        int[][] pixelMatrix = new int[width][height];
        PixelReader reader = image.getPixelReader();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // store alpha, red, green, blue stored in an int
                pixelMatrix[x][y] = reader.getArgb(x, y);
            }
        }
        return pixelMatrix;
    }

    public static Image getImage(int[][] pixelMatrix) {
        WritableImage writableImage = new WritableImage(pixelMatrix.length, pixelMatrix[0].length);
        for (int i = 0; i < pixelMatrix.length; i++){
            for (int j = 0; j < pixelMatrix[0].length; j++){
                writableImage.getPixelWriter().setArgb(i,j, pixelMatrix[i][j]);
            }
        }
        return writableImage;

    }
}
