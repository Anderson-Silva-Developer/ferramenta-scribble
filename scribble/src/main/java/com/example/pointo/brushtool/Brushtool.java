package com.example.pointo.brushtool;

import com.example.pointo.components.Components;
import com.example.pointo.coordinates.Coordinates;

import java.util.ArrayList;

public class Brushtool {

    private ArrayList<Coordinates> coordinates;
    private Components components;

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    private Brushtool(ArrayList<Coordinates> coordinates, Components components) {
        this.coordinates = coordinates;
        this.components = components;
    }

    public static  class BrushtoolBuilder{
        private ArrayList<Coordinates> coordinates;
        private Components components;
        public BrushtoolBuilder() { }
        public BrushtoolBuilder coordinates(ArrayList<Coordinates> coordinates) {
            this.coordinates=coordinates;
            return this;

        }
        public BrushtoolBuilder components(Components components) {
            this.components=components;
            return this;
        }
        public Brushtool createBuilder(){
            return new Brushtool(coordinates,components);
        }
    }

}
