module dam.di.componentesGTC {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.base;
    exports ComponentesGTC;
    opens ComponentesGTC to javafx.fxml;
}