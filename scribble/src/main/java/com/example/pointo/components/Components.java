package com.example.pointo.components;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class Components {
    private Canvas canvas;
    private Group groupColor;
    private Group groupLine;
    private Pane menu;
    private Paint color;
    private int thickness;

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Group getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(Group groupColor) {
        this.groupColor = groupColor;
    }

    public Group getGroupLine() {
        return groupLine;
    }

    public void setGroupLine(Group groupLine) {
        this.groupLine = groupLine;
    }

    public Pane getMenu() {
        return menu;
    }

    public void setMenu(Pane menu) {
        this.menu = menu;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    private Components(Canvas canvas, Group groupColor, Group groupLine, Pane menu, Paint color, int thickness) {
        this.canvas = canvas;
        this.groupColor = groupColor;
        this.groupLine = groupLine;
        this.menu = menu;
        this.color = color;
        this.thickness=thickness;
    }

    public  static  class  ToDrawBuilder{
        private Canvas canvas;
        private Group groupColor;
        private Group groupLine;
        private Pane menu;
        private Paint color;
        private int thickness;

        public  ToDrawBuilder (){ }

        public ToDrawBuilder canvas(Canvas canvas) {
            this.canvas=canvas;
            return this;

        }
        public  ToDrawBuilder groupColor( Group groupColor){
            this.groupColor=groupColor;
            return this;

        }
        public  ToDrawBuilder groupLine(Group groupLine){
            this.groupLine=groupLine;
            return this;

        }
        public  ToDrawBuilder menu(Pane menu){
            this.menu=menu;
            return  this;

        }
        public  ToDrawBuilder color(Paint color){
            this.color=color;
            return this;

        }
        public  ToDrawBuilder thickness(int thickness){
            this.thickness=thickness;
            return this;

        }
        public Components creteBuilder(){
            return new Components(canvas,groupColor,groupLine,menu,color,thickness);
        }


    }
}
