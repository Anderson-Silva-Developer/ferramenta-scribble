package com.example.pointo.actions;

import com.example.pointo.components.Components;
import com.example.pointo.coordinates.Coordinates;

import java.util.ArrayList;

public class keyboardActions {
    private ArrayList<ArrayList<Coordinates>> coords;
    private Components components;

    public ArrayList<ArrayList<Coordinates>>getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<ArrayList<Coordinates>> coords) {
        this.coords = coords;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    private keyboardActions(ArrayList<ArrayList<Coordinates>> coords, Components components) {
        this.coords = coords;
        this.components = components;
    }
    public static class  keyboardActionsBuilder{
        private ArrayList<ArrayList<Coordinates>> coords;
        private Components components;

        public keyboardActionsBuilder() { }
        public keyboardActionsBuilder coords(ArrayList<ArrayList<Coordinates>> coords) {
            this.coords=coords;
            return this;
        }
        public keyboardActionsBuilder components(Components components) {
            this.components=components;
            return this;
        }
        public  keyboardActions createBuilder(){
            return new keyboardActions(coords,components);
        }

    }


    public void undo(){
        if(this.coords.size()>0) {
           this.components.getCanvas()
                   .getGraphicsContext2D()
                   .clearRect(0, 0, components.getCanvas().getWidth(), components.getCanvas().getHeight());
            this.coords.remove(this.coords.size()-1);

           this.coords.forEach(coordinates -> {
                for (int i = 1; i < coordinates.size(); i++) {
                    int x_ = coordinates.get(i).getCoordX();
                    int y_ = coordinates.get(i).getCoordY();
                    int x2_ = coordinates.get(i - 1).getCoordX();
                    int y2_ = coordinates.get(i - 1).getCoordY();//
                    this.components.getCanvas().getGraphicsContext2D().setLineWidth(coordinates.get(i).getThickness());
                    this.components.getCanvas().getGraphicsContext2D().setStroke(coordinates.get(i).getStroke());
                    this.components.getCanvas().getGraphicsContext2D().strokeLine(x2_, y2_, x_, y_);

                }

            });
        }

    }
}
