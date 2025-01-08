module com.example.chickencraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.chickencraft to javafx.fxml;
    exports com.example.chickencraft;
}