module bht.quizduell {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.sql;

    opens bht.quizduell to javafx.fxml;
    exports bht.quizduell;
}