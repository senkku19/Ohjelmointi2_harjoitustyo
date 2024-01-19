module com.example.harjoitustyo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.harjoitustyo to javafx.fxml;
    exports com.example.harjoitustyo;
}