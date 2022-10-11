package com.kth.lab4.model.handlers;

import javafx.scene.paint.Color;

import static java.lang.Math.floor;

public class BlurHandlerImpl implements IImageHandler{
    @Override
    public int[][] processImage(int[][] originalImg) {
        int[][] blurredImageMatrix = new int[originalImg.length][originalImg[0].length];
        // Setting dimensions for the image to be processed
        int i = 0;
        int max = 400, rad = 10;
        int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
        Color color[] = new Color[max];

        // Now this core section of code is responsible for
        // blurring of an image

        int x = 1, y = 1, x1, y1, ex = 5, d = 0;

        // Running nested for loops for each pixel
        // and blurring it
        for (x = rad; x < originalImg[0].length - rad; x++) {
            for (y = rad; y < originalImg.length - rad; y++) {
                for (x1 = x - rad; x1 < x + rad; x1++) {
                    for (y1 = y - rad; y1 < y + rad; y1++) {

                        a1 = (originalImg[y1][x1]>>24)&0xFF;
                        r1 = (originalImg[y1][x1]>>16)&0xFF;
                        g1 = (originalImg[y1][x1]>>8)&0xFF;
                        b1 = (originalImg[y1][x1])&0xFF;
                        color[i++] = new Color((double) r1/255,(double) g1/255,(double) b1/255,(double) a1/255);

                    }
                }

                // Smoothing colors of image
                i = 0;
                for (d = 0; d < max; d++) {
                    a1 = a1 + (int) color[d].getOpacity();

                }

                a1 = a1 / (max);

                for (d = 0; d < max; d++) {
                    r1 = r1 + (int) color[d].getRed();

                }
                System.out.println("MAX "+ r1);
                r1 = r1 / (max);
                for (d = 0; d < max; d++) {
                    g1 = g1 + (int) color[d].getGreen();
                }

                g1 = g1 / (max);
                for (d = 0; d < max; d++) {
                    b1 = b1 + (int)color[d].getBlue();
                }

                b1 = b1 / (max);
                int sum1 = (a1 << 24) + (r1 << 16) + (g1 << 8) + b1;
                System.out.println(sum1);
                blurredImageMatrix[y][x] = sum1;
            }
        }


        return blurredImageMatrix;
    }
}
