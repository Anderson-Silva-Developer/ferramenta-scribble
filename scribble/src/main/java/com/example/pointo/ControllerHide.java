package com.example.pointo;

import com.example.pointo.actions.ActionsCanvas;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class ControllerHide {
    @FXML
    private AnchorPane base;
    public static Pane pane_;

    @FXML
    void initialize(){
        pane_=base;

    }
    @FXML
    public void  show(){
        Main.changeScreen("main");
    }
    @FXML
    void Exit(MouseEvent event) {
        System.exit(0);

    }

}