module com.example.a4_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.a4_3 to javafx.fxml;
    exports com.example.a4_3;
}