package com.example.pointo.actions;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ActionsMenu {
    private   double xoffset=0;
    private  double yoffset=0;

    public double getXoffset() {
        return xoffset;
    }

    public void setXoffset(double xoffset) {
        this.xoffset = xoffset;
    }

    private ActionsMenu(double xoffset, double yoffset) {
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }
    public static class   ActionsMenuBuilder{
        private   double xoffset;
        private  double yoffset;

        public ActionsMenuBuilder() {

        }
        public ActionsMenuBuilder xoffset(double xoffset){
            this.xoffset=xoffset;
            return this;
        }
        public ActionsMenuBuilder yoffset(double yoffset){
            this.yoffset=yoffset;
            return this;
        }
        public ActionsMenu createBuilder(){
            return new ActionsMenu(xoffset,yoffset);
        }

    }


    public void  ActionspaneMenu(Pane pane){
       pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xoffset=mouseEvent.getX();
                yoffset=mouseEvent.getY();
            }
        });
        pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pane.setLayoutX(mouseEvent.getScreenX()-xoffset);
                pane.setLayoutY(mouseEvent.getScreenY()-yoffset);
            }
        });
    }
}
