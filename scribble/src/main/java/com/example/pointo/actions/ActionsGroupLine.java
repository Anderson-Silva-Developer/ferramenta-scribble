package com.example.pointo.actions;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class ActionsGroupLine {
    private int thickness;

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    private ActionsGroupLine(int largura) {
        this.thickness =largura;
    }
    public static class  ActionsGroupLineBuilder{
        private int thickness;

        public ActionsGroupLineBuilder() {

        }
        public ActionsGroupLineBuilder thickness(int largura){
            this.thickness =largura;
            return this;
        }
        public ActionsGroupLine createBuilder(){
            return new ActionsGroupLine(thickness);
        }
    }


    public void  setActionLine(Group gLine){
        gLine.getChildren().forEach(node -> {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    node.setScaleX(1);
                    node.setScaleY(1);
                    thickness =(int)(((Line)node).getStrokeWidth())-2;
                    gLine.getChildren().forEach(rect-> {
                        if(rect!=node){
                            rect.setScaleX(0.5);

                        }
                    });
                }
            });

        });

    }
}
