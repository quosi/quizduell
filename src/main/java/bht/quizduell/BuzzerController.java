package bht.quizduell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class BuzzerController {
    @FXML
    private Button keypress_a;

    @FXML
    private Button keypress_k;
// click is handled with invisible buttons !!!

    @FXML
    private void whichKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.A) {
            System.out.println("A was pressed");
            // immediately change scene here
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("question.fxml"));
                //root.setFocusTraversable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage window = (Stage) keypress_a.getScene().getWindow(); // typecast to Stage
            window.setScene((new Scene(root)));

            window.setTitle("Let's see who's faster :)");

        }
        if (keyEvent.getCode() == KeyCode.K) {
            System.out.println("K was pressed");
            // immediately change scene here
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("question.fxml"));
                //root.setFocusTraversable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage window = (Stage) keypress_k.getScene().getWindow(); // typecast to Stage
            window.setScene((new Scene(root)));

            window.setTitle("Let's see who's faster :)");
        }
        System.out.println("here");
    }
}

