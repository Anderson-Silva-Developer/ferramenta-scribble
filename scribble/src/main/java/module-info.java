module com.example.pointo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
   requires javafx.swing;


    opens com.example.pointo to javafx.fxml;
    exports com.example.pointo;
    exports com.example.pointo.coordinates;
    opens com.example.pointo.coordinates to javafx.fxml;
}