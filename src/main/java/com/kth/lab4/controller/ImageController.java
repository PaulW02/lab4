package com.kth.lab4.controller;

import com.kth.lab4.model.ImageService;
import com.kth.lab4.model.handlers.BlurHandlerImpl;
import com.kth.lab4.model.handlers.ContrastHandlerImpl;
import com.kth.lab4.model.handlers.EdgeIntensifierHandlerImpl;
import com.kth.lab4.model.handlers.InvertColorHandlerImpl;
import com.kth.lab4.view.ImagePixelMatrixConverter;
import javafx.scene.image.Image;

public class ImageController {

    private ImageService imageService;
    public ImageController(Image image) {
        this.imageService = new ImageService(ImagePixelMatrixConverter.getPixelMatrix(image));
    }

    public int[][] handleHistogramSelected(){
        return imageService.createHistogram(new int[10][10]);
    }

    public int[][] changeImageContrast(int window, int level){
        return imageService.handleImage(new ContrastHandlerImpl(window, level));
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
