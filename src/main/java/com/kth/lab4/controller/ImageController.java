package com.kth.lab4.controller;

import com.kth.lab4.model.ImageService;
import com.kth.lab4.model.handlers.BlurHandlerImpl;
import com.kth.lab4.model.handlers.ContrastHandlerImpl;
import com.kth.lab4.model.handlers.EdgeIntensifierHandlerImpl;
import com.kth.lab4.model.handlers.InvertColorHandlerImpl;

public class ImageController {

    private ImageService imageService;
    public ImageController(int[][] matrix) {
        this.imageService = new ImageService(matrix);
    }

    public int[][] handleHistogramSelected(){
        return imageService.createHistogram(new int[10][10]);
    }

    public void changeImageContrast(){
        imageService.handleImage(new ContrastHandlerImpl());
    }

    public int[][] blurImage(){
        return imageService.handleImage(new BlurHandlerImpl());
    }

    public int[][] invertImageColors(){
        return imageService.handleImage(new InvertColorHandlerImpl());
    }

    public int[][] intensifyImageEdges(){
        return imageService.handleImage(new EdgeIntensifierHandlerImpl());
    }

}
