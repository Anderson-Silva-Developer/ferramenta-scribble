package com.example.pointo.actions;

import com.example.pointo.ControllerMain;
import com.example.pointo.components.Components;
import com.example.pointo.coordinates.Coordinates;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ActionsCanvas {
    public ActionsCanvas() {
    }
    public void actionCanvasShortcut(AnchorPane base , keyboardActions keyboard){

        final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.Z,
                KeyCombination.CONTROL_DOWN);
        base.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (keyComb1.match(event)) {
                    keyboard.undo();

                }

            }
        });


    }
    public void actionCanvasclearScribble(ArrayList<ArrayList<Coordinates>> coords , Slider raioClear, MouseEvent event, Components components){
        for (int i=(int)event.getX();i<((int)event.getX())+raioClear.getValue();i++){///////////////
            for (int j=(int)event.getY();j<((int)event.getY())+raioClear.getValue();j++){

                int finalI = i;
                int finalJ = j;
                coords.forEach(coordinates -> {
                    coordinates.forEach(coord_ -> {
                        if(finalI ==coord_.getCoordX() && finalJ ==coord_.getCoordY()){
                            if(ControllerMain.status.contains(coords.indexOf(coordinates))==false) {
                                ControllerMain.status.add(coords.indexOf(coordinates));
                            }
                        }
                    });
                });

            }
        }

        components.getCanvas()
                .getGraphicsContext2D()
                .clearRect(event.getX(), event.getY(), raioClear.getValue(), raioClear.getValue());




    }



}
