package com.example.pointo.actions;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ActionsMenu {
    private   double xoffset=0;
    private  double yoffset=0;
    private  int MaxX=0;
    private  int MaxY=0;

    public double getYoffset() {
        return yoffset;
    }

    public void setYoffset(double yoffset) {
        this.yoffset = yoffset;
    }

    public int getMaxX() {
        return MaxX;
    }

    public void setMaxX(int maxX) {
        MaxX = maxX;
    }

    public int getMaxY() {
        return MaxY;
    }

    public void setMaxY(int maxY) {
        MaxY = maxY;
    }

    public double getXoffset() {
        return xoffset;
    }

    public void setXoffset(double xoffset) {
        this.xoffset = xoffset;
    }

    private ActionsMenu(double xoffset, double yoffset,int MaxX,int MaxY) {
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.MaxX=MaxX;
        this.MaxY=MaxY;
    }
    public static class   ActionsMenuBuilder{
        private   double xoffset;
        private  double yoffset;
        private  int MaxX=0;
        private  int MaxY=0;

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

        public  ActionsMenuBuilder MaxX(int MaxX){
            this.MaxX=MaxX;
            return  this;

        }
        public  ActionsMenuBuilder MaxY(int MaxY){
            this.MaxY=MaxY;
            return  this;

        }
        public ActionsMenu createBuilder(){
            return new ActionsMenu(xoffset,yoffset,MaxX,MaxY);
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

                if((mouseEvent.getScreenX() - xoffset)>1 && (mouseEvent.getScreenX() - xoffset) < (MaxX-90) && (mouseEvent.getScreenY() - yoffset)>1 && (mouseEvent.getScreenY() - yoffset)<MaxY-100) {
                    pane.setLayoutX(mouseEvent.getScreenX() - xoffset);
                    pane.setLayoutY(mouseEvent.getScreenY() - yoffset);
                    System.out.println("movimento real");
                    System.out.println(pane.getLayoutX());
                    System.out.println(pane.getLayoutY());
                }
            }
        });
    }
}
