package com.example.pointo.actions;

import com.example.pointo.ControllerMain;
import com.example.pointo.Main;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ActionsGroupColor {
    private  Paint color;
    private  Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    private ActionsGroupColor(Paint color, Canvas canvas) {
        this.color=color;
        this.canvas=canvas;
    }
    public  static class ActionsGroupColorBuilder {
        private  Paint color;
        private  Canvas canvas;

        public ActionsGroupColorBuilder() {

        }
        public ActionsGroupColorBuilder color(Paint color){
            this.color=color;
            return this;
        }
        public ActionsGroupColorBuilder canvas(Canvas canvas){
            this.canvas=canvas;
            return this;
        }
        public ActionsGroupColor createBuilder(){
            return new ActionsGroupColor(color,canvas);
        }
    }

    public void  setActionColor(Group gColor,Group groupLine){

        gColor.getChildren().forEach(node -> {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                       Image img=new Image(Main.class.getResourceAsStream("/img/cursor_"+node.getId()+".png"));
                        canvas.setCursor(new ImageCursor(img));
                    }catch (Exception e){e.getMessage();}
                    node.setScaleX(0.5);
                    node.setScaleY(0.5);
                    color=((Rectangle)node).getFill();
                    setColorLine(groupLine);
                    ControllerMain.clearCanvas=false;
                    ControllerMain.raioClear_.setVisible(false);
                    gColor.getChildren().forEach(rect-> {
                        if(rect!=node){
                            rect.setScaleX(1);
                            rect.setScaleY(1);
                        }
                    });
                }
            });

        });

    }
    private  void setColorLine(Group groupLine){
        groupLine.getChildren().forEach(line -> {
            ((Line)line).setStroke(color);

        });

    }

}
