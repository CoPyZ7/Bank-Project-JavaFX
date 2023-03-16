module com.example.bankproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.bankproject to javafx.fxml;
    exports com.example.bankproject;
}