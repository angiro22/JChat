module com.angiro22.jchat {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.angiro22.jchat to javafx.fxml;
    exports com.angiro22.jchat;
}