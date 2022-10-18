package com.kth.lab4.controller;

import com.kth.lab4.model.ImageService;
import com.kth.lab4.model.handlers.BlurHandlerImpl;
import com.kth.lab4.model.handlers.ContrastHandlerImpl;
import com.kth.lab4.model.handlers.EdgeIntensifierHandlerImpl;
import com.kth.lab4.model.handlers.InvertColorHandlerImpl;
import com.kth.lab4.model.ImagePixelMatrixConverter;
import javafx.scene.image.Image;

public class ImageController {

    private ImageService imageService;
    public ImageController(Image image) {
        this.imageService = new ImageService(ImagePixelMatrixConverter.getPixelMatrix(image));
    }

    public int[][] handleHistogramSelected(){
        return imageService.createHistogram();
    }

    public Image changeImageContrast(int window, int level){
        return ImagePixelMatrixConverter.getImage(imageService.handleImage(new ContrastHandlerImpl(window, level)));
    }

    public Image blurImage(){
        return ImagePixelMatrixConverter.getImage(imageService.handleImage(new BlurHandlerImpl()));
    }

    public Image invertImageColors(){
        return ImagePixelMatrixConverter.getImage(imageService.handleImage(new InvertColorHandlerImpl()));
    }

    public Image intensifyImageEdges(){
        return ImagePixelMatrixConverter.getImage(imageService.handleImage(new EdgeIntensifierHandlerImpl()));
    }

}
