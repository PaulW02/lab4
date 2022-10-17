package com.kth.lab4.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImagePixelMatrixConverter {

    /**
     * Takes an uploaded image and turns it in to a 2D-matrix with pixels and returns it.
     * @param image the image that has been uploaded.
     * @return the pixel matrix of the image.
     */
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

    /**
     * takes a pixel matrix and turns it into an image and returns it.
     * @param pixelMatrix  the matrix that is to be reformed to an image.
     * @return the image that has been converted from a matrix.
     */
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
