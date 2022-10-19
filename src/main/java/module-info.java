module com.example.cs2340campusdiscovery {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs2340campusdiscovery to javafx.fxml;
    exports com.example.cs2340campusdiscovery;
}