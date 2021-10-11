package com.example.pointo.actions;

import com.example.pointo.ControllerMain;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ActionsCanvas {
    public ActionsCanvas() {
    }
    public void actionCanvas(AnchorPane base ,keyboardActions keyboard){

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
}
