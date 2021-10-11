package com.example.pointo.actions;


import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.robot.Robot;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class ActionsScreen {
    public ActionsScreen() {
    }
    public void actionsScreen(Rectangle2D screenBounds, Button btnscreen, AnchorPane base){

        btnscreen.setOnAction((ActionEvent event) -> {
            try {
            Robot robot=new Robot();
            Rectangle2D rectangle2D=new Rectangle2D(0,0,(int) screenBounds.getMaxX(),(int)screenBounds.getMaxY());
            WritableImage image = robot.getScreenCapture(null, rectangle2D);
            String dir = System.getProperty("user.dir");
            File file = new File(dir);
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                    "image files (*.png)", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showSaveDialog(base.getScene().getWindow());
            if(file!=null) {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
            } catch (IOException e) {
                System.out.println("Não foi possível capturar imagem do video");
            }


        });
    }
}
