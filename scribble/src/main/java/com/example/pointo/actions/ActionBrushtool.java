package com.example.pointo.actions;

import com.example.pointo.brushtool.Brushtool;
import com.example.pointo.coordinates.Coordinates;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class ActionBrushtool {

    private MouseEvent event;
    private  Brushtool brushtool;

    public MouseEvent getEvent() {
        return event;
    }

    public void setEvent(MouseEvent event) {
        this.event = event;
    }

    public Brushtool getBrushtool() {
        return brushtool;
    }

    public void setBrushtool(Brushtool brushtool) {
        this.brushtool = brushtool;
    }

    private ActionBrushtool(MouseEvent event, Brushtool brushtool) {
        this.event = event;
        this.brushtool = brushtool;
    }
    public static class ActionBrushtoolBuilder{
        private MouseEvent event;
        private  Brushtool brushtool;

        public ActionBrushtoolBuilder() { }
        public ActionBrushtoolBuilder event(MouseEvent event) {
            this.event=event;
            return this;
        }
        public ActionBrushtoolBuilder brushtool(Brushtool brushtool) {
            this.brushtool=brushtool;
            return this;
        }
        public ActionBrushtool createBuilder(){
            return new ActionBrushtool(event,brushtool);
        }
    }

    public void DrawOnScreen(Paint stroke) {
        GraphicsContext gc =this.brushtool.getComponents().getCanvas().getGraphicsContext2D();
        gc.setLineWidth(this.brushtool.getComponents().getThickness());
        gc.setStroke(this.brushtool.getComponents().getColor());
        Coordinates coordinates=new Coordinates.CoordinatesBuilder()
                .coordX((int)this.event.getX())
                .coordY((int)this.event.getY())
                .stroke(stroke)
                .thickness(this.brushtool.getComponents().getThickness())
                .createBuilder();

        this.brushtool.getCoordinates().add(coordinates);

        for(int i = 1; i< this.brushtool.getCoordinates().size(); i++){
            int x_= this.brushtool.getCoordinates().get(i).getCoordX();
            int y_= this.brushtool.getCoordinates().get(i).getCoordY();
            int x2_= this.brushtool.getCoordinates().get(i-1).getCoordX();
            int y2_= this.brushtool.getCoordinates().get(i-1).getCoordY();
            gc.strokeLine(x2_, y2_, x_, y_);


        }

    }

}
