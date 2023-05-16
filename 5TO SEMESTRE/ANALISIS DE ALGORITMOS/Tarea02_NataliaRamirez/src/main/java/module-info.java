module com.mycompany.tarea02_nataliaramirez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tarea02_nataliaramirez to javafx.fxml;
    exports com.mycompany.tarea02_nataliaramirez;
}