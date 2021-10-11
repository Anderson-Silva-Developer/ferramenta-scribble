package com.example.pointo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private  static  Stage stage;
    private  static  Scene mainScene;
    private  static  Scene  hideScene;
    private static  double coordX=0;
    private static  double coordY=0;
    private static Rectangle2D screenBounds = Screen.getPrimary().getBounds();




    public static void setCoordY(double coordY) {
        Main.coordY = coordY;
    }

    private double xoffset=0;
    private double yoffset=0;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setAlwaysOnTop(true);
        stage=primaryStage;
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        int lar = (int) screenBounds.getMaxX();
        int alt = (int) screenBounds.getMaxY();
        primaryStage.setTitle("mypainter");
        FXMLLoader rootMain = new FXMLLoader(Main.class.getResource("my_painter.fxml"));
        Scene sceneMain = new Scene(rootMain.load(),lar,alt);
        mainScene=sceneMain;
        FXMLLoader rootHide = new FXMLLoader(Main.class.getResource("my_painter2.fxml"));
        Scene sceneHide = new Scene(rootHide.load());
        hideScene=sceneHide;
        sceneMain.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        sceneMain.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xoffset=mouseEvent.getSceneX();
                yoffset=mouseEvent.getSceneY();

            }
        });
        sceneMain.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                    primaryStage.setX(mouseEvent.getScreenX() - xoffset);
                    primaryStage.setY(mouseEvent.getScreenY() - yoffset);
                    coordX = primaryStage.getX();
                    coordY = primaryStage.getY();



            }
        });
        ////
        sceneHide.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xoffset=mouseEvent.getSceneX();
                yoffset=mouseEvent.getSceneY();

            }
        });
        sceneHide.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                primaryStage.setX(mouseEvent.getScreenX()-xoffset);
                primaryStage.setY(mouseEvent.getScreenY()-yoffset);
                coordX=primaryStage.getX();
                coordY=primaryStage.getY();


            }
        });

        ///
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }
    public static void changeScreen(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                stage.setAlwaysOnTop(true);
                ControllerMain.pane_.setLayoutX(coordX=coordX<1?1:coordX);
                ControllerMain.pane_.setLayoutX(coordX=coordX>screenBounds.getMaxX()-90?(screenBounds.getMaxX()-90):coordX);
                ControllerMain.pane_.setLayoutY(coordY=coordY<1?1:coordY);
                ControllerMain.pane_.setLayoutY(coordY=coordY>screenBounds.getMaxY()-100?screenBounds.getMaxY()-100:coordY);
//
                break;

            case  "hide":
                stage.setScene(hideScene);
                stage.setAlwaysOnTop(true);
                stage.setX(ControllerMain.pane_.getLayoutX());
                stage.setY(ControllerMain.pane_.getLayoutY());

                break;

        }

    }


    public static void main(String[] args) {
        launch();
    }
}