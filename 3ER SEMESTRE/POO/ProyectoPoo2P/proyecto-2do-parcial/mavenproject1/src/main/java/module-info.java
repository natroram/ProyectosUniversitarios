module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;
    exports com.mycompany.mavenproject1;
    exports utilidades;
    opens utilidades to javafx.base;
    //opens utilidades to javafx.graphics;
}