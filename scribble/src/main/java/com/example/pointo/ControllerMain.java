package com.example.pointo;

import com.example.pointo.actions.*;
import com.example.pointo.brushtool.Brushtool;
import com.example.pointo.components.Components;
import com.example.pointo.coordinates.Coordinates;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.io.IOException;
import java.util.ArrayList;


public class ControllerMain {

    @FXML
    private Button captureScreen;
    @FXML
    private AnchorPane base;

    private Rectangle rectangleMouse;
    @FXML
    private Slider raioClear;
    @FXML
    private Group groupColor;
    @FXML
    private Group groupLine;
    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;
    public static boolean clearCanvas=false;
    int thickness =2;
    Paint color;
    ArrayList<Coordinates> coord =new ArrayList<>();
    ArrayList<ArrayList<Coordinates>>coords =new ArrayList<>();
    ArrayList<GraphicsContext> stoke=new ArrayList<>();
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    ActionsGroupColor actionColor;
    ActionsGroupLine actionLine;
    ActionsMenu actionsMenu;
    ActionBrushtool actionBrushtool;
    Components components;
    Brushtool brushtool;
    ActionsScreen actionsScreen;
    ActionsCanvas actionsCanvas=new ActionsCanvas();
    keyboardActions keyboard;
    public static Pane pane_;
    public static Slider raioClear_;

    @FXML
    void initialize(){
        System.out.println(screenBounds.getMaxX()+" "+screenBounds.getMaxY());
        raioClear_=raioClear;
        pane_=pane;
        actionsScreen=new ActionsScreen();
        actionsScreen.actionsScreen(screenBounds,captureScreen,base);
        this.rectangleMouse=new Rectangle(100,100);
        this.rectangleMouse.setFill(Color.YELLOW);
        this.rectangleMouse.setOpacity(0.36);
        this.rectangleMouse.setVisible(false);
        base.getChildren().add(this.rectangleMouse);
        int lar = (int) screenBounds.getMaxX();
        int alt = (int) screenBounds.getMaxY();
        color=Paint.valueOf("#000");
        canvas.setWidth(lar);
        canvas.setHeight(alt);

        Image img=new Image(Main.class.getResourceAsStream("/img/cursor_black.png"));
        canvas.setCursor(new ImageCursor(img));
        //create components
        components =new Components.ToDrawBuilder()
                .canvas(canvas)
                .groupColor(groupColor)
                .groupLine(groupLine)
                .menu(pane)
                .color(color)
                .thickness(thickness)
                .creteBuilder();
        //actions components
        keyboard=new keyboardActions.keyboardActionsBuilder()
                .components(components)
                .coords(coords)
                .createBuilder();

        actionsCanvas.actionCanvas(base,keyboard);

        actionColor=new ActionsGroupColor.ActionsGroupColorBuilder()
                .color(components.getColor())
                .canvas(components.getCanvas())
                .createBuilder();
        actionColor.setActionColor(components.getGroupColor(), components.getGroupLine());

        actionLine=new ActionsGroupLine.ActionsGroupLineBuilder()
                .thickness(components.getThickness())
                .createBuilder();
        actionLine.setActionLine(components.getGroupLine());

        actionsMenu=new ActionsMenu.ActionsMenuBuilder()
                .xoffset(0.0)
                .yoffset(0.0)
                .createBuilder();
        components.getMenu().setLayoutX(lar-200);

        actionsMenu.ActionspaneMenu(components.getMenu());
        ///
        ///create brushtool
        brushtool=new Brushtool.BrushtoolBuilder()
                .coordinates(coord)
                .components(components)
                .createBuilder();
        //Action Brushtool
        actionBrushtool=new ActionBrushtool.ActionBrushtoolBuilder()
                .brushtool(brushtool)
                .createBuilder();

    }
    @FXML
    void DrawOnScreen(MouseEvent event) {
        if(!clearCanvas) {
            actionBrushtool.setEvent(event);
            components.setColor(actionColor.getColor());
            components.setThickness(actionLine.getThickness());
            actionBrushtool.DrawOnScreen(actionColor.getColor());

        }else{
            this.rectangleMouse.setVisible(true);
            clearLineCanvas(event);
        }
    }

    void visibleCircleMouse(){
        this.rectangleMouse.setVisible(false);
    }
    @FXML
    void clearCanvas(MouseEvent event){
            components.getCanvas()
                    .getGraphicsContext2D()
                    .clearRect(0, 0, components.getCanvas().getWidth(), components.getCanvas().getHeight());

    }
    @FXML
    void clearLineCanvas(MouseEvent event){

        if(clearCanvas) {
            this.rectangleMouse.setLayoutX(event.getX());
            this.rectangleMouse.setLayoutY(event.getY());
            this.rectangleMouse.setWidth(raioClear.getValue());
            this.rectangleMouse.setHeight(raioClear.getValue());

            components.getCanvas()
                    .getGraphicsContext2D()
                    .clearRect(event.getX(), event.getY(), raioClear.getValue(), raioClear.getValue());
            
        }
    }
    @FXML
    void clearCanvasValue(){
        clearCanvas=!clearCanvas;
        if(clearCanvas) {
            this.raioClear.setVisible(true);
            Image im=new Image(Main.class.getResourceAsStream("/img/clear.png"));
            components.getCanvas().setCursor(new ImageCursor(im));
        }
    }
    @FXML
    void clearlistCoord(MouseEvent event){
        if(brushtool.getCoordinates().size()>0){
            coords.add((ArrayList<Coordinates>) brushtool.getCoordinates().clone());
            brushtool.getCoordinates().clear();
        }

        visibleCircleMouse();

    }
    @FXML
    void hidePainter() throws IOException {
        Main.changeScreen("hide");
    }


    }

