package com.kth.lab4.io;

import com.kth.lab4.model.exceptions.IllegalImageFormatException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileIO {
    public static Image openAndLoadImage(Stage stage) throws IllegalImageFormatException{
        File file = new FileChooser().showOpenDialog(stage);
        if(file != null) {
            return new Image(file.toURI().toString());
        }
        throw new IllegalImageFormatException();
    }

    public static void saveImage(Image image) throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null); // convert to BufferedImage
        ImageIO.write(bufferedImage, "png", new File("copy.png")); // write image to file, in this case type "png"
    }
}
