module com.example.a3_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.a3_2 to javafx.fxml;
    exports com.example.a3_2;
}