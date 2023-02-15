module com.ums {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ums to javafx.fxml;
    exports com.ums;
    exports com.ums.ui;
    exports com.ums.model;

}