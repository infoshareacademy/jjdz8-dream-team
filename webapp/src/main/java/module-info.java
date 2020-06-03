module javafx{

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    //opens org.openjfx to javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.logging;
    requires javafx.swing;
    requires com.google.gson;
    requires javax.servlet;
    requires javax.servlet.jsp.jstl;
    exports com.infoshareacademy.KasiaWykresy.src.Wykresy;

}
