module com.example.todolistnewapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.todolistnewapp to javafx.fxml;
    exports com.example.todolistnewapp;
}