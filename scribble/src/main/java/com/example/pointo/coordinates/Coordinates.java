package com.example.pointo.coordinates;


import javafx.scene.paint.Paint;

public class Coordinates {
    private int coordX;
    private int coordY;
    private Paint stroke;

    public Paint getStroke() {
        return stroke;
    }

    public void setStroke(Paint stroke) {
        this.stroke = stroke;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    private Coordinates(int x, int y,Paint stroke) {
        this.coordX = x;
        this.coordY = y;
        this.stroke=stroke;
    }
    public static class CoordinatesBuilder{
        private int coordX;
        private int coordY;
        private Paint stroke;

        public CoordinatesBuilder() {

        }
        public CoordinatesBuilder coordX(int coordX){
            this.coordX=coordX;
            return this;
        }
        public CoordinatesBuilder coordY(int coordY){
            this.coordY=coordY;
            return this;
        }
        public CoordinatesBuilder stroke(Paint stroke){
            this.stroke=stroke;
            return this;
        }

        public  Coordinates createBuilder(){
            return new Coordinates(coordX,coordY,stroke);
        }
    }
}
