module com.francesco.rubrica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.francesco.rubrica to javafx.fxml;
    exports com.francesco.rubrica.Interface;
    opens com.francesco.rubrica.Interface to javafx.fxml;
    exports com.francesco.rubrica.Data;
    opens com.francesco.rubrica.Data to javafx.fxml;
    exports com.francesco.rubrica.Main;
    opens com.francesco.rubrica.Main to javafx.fxml;
}