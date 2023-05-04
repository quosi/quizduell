module bht.quizduell {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens bht.quizduell to javafx.fxml;
    exports bht.quizduell;
}