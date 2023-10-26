module com.example.programacion3_parcial {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires javafx.graphics;

    exports com.example.programacion3_parcial2.ejercicio1;
    exports com.example.programacion3_parcial2.ejercicio1.model;
    exports com.example.programacion3_parcial2.ejercicio1.controller;

    opens com.example.programacion3_parcial2.ejercicio1.controller to javafx.fxml;


}