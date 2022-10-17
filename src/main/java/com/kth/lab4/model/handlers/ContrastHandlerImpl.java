package com.kth.lab4.model.handlers;

import com.kth.lab4.model.exceptions.IllegalWindowLevelException;

public class ContrastHandlerImpl implements IImageHandler{

    private final int window;
    private final int level;

    public ContrastHandlerImpl(int window, int level) throws IllegalWindowLevelException {
        if ((window > 0 && window < 256) && (level > 0 && level < 256)) {
            this.window = window;
            this.level = level;
        }else{
            throw new IllegalWindowLevelException("Either window or level value is not between 1 and 255!");
        }
    }

    /**
     * Takes a 2D matrix of an image and returns a matrix with a grayscale calculated with level and window.
     * @param originalImg gets the 2D matrix of the original image.
     * @return the matrix of the grayscale that has been calculated.
     */
    @Override
    public int[][] processImage(int[][] originalImg) {
        int color;
        int[] argb = new int[4];
        int[][] grayScale = new int[originalImg.length][originalImg[0].length];
        for (int i = 0; i < originalImg.length; i++) {
            for (int j = 0; j < originalImg[0].length; j++) {
                color = originalImg[i][j];
                argb[0] = ((color >> 24) & 0xff);
                argb[1] = ((color >> 16) & 0xff);
                argb[2] = ((color >> 8) & 0xff);
                argb[3] = ((color) & 0xff);
                for (int k = 0; k < argb.length; k++) {
                    if (argb[k] < level){
                        argb[k] = 0;
                    } else if (argb[k] > level-1 && argb[k] < (level+window+1)) {
                        argb[k] = Math.round((255/window)*(argb[k]-level));
                    } else if (argb[k] > (level+window) && argb[k] < 256) {
                        argb[k] = 255;
                    }
                }
                grayScale[i][j] = (argb[0] << 24) | (argb[1] << 16) | (argb[2] << 8) | argb[3];
            }
        }

        return grayScale;
    }
}
