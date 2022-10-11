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

    public void handleHistogramSelected(){}

    public void changeImageContrast(){
        imageService.handleImage(new ContrastHandlerImpl());
    }

    public int[][] blurImage(){
        return imageService.handleImage(new BlurHandlerImpl());
    }

    public void invertImageColors(){
        imageService.handleImage(new InvertColorHandlerImpl());
    }

    public void intensifyImageEdges(){
        imageService.handleImage(new EdgeIntensifierHandlerImpl());
    }

}
