module com.kth.lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    //requires javafx.swing;

    opens com.kth.lab4 to javafx.fxml;
    exports com.kth.lab4;
    exports com.kth.lab4.view;
    opens com.kth.lab4.view to javafx.fxml;
}