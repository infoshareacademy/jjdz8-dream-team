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
    exports com.infoshareacademy.Wykresy;

}
