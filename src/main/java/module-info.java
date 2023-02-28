module com.example.clinicaprivata {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.clinicaprivata to javafx.fxml;
    exports com.example.clinicaprivata;
    opens com.example.clinicaprivata.domain to javafx.fxml;
    exports com.example.clinicaprivata.domain;
    opens com.example.clinicaprivata.repository to javafx.fxml;
    exports com.example.clinicaprivata.repository;
    opens com.example.clinicaprivata.service to javafx.fxml;
    exports com.example.clinicaprivata.service;
}