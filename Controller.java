package com.example.bhtduell;

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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private Label player1_error;
    @FXML
    private Label player2_error;
    @FXML
    private Label successful_login;
    @FXML
    private ImageView login_image_1;
    @FXML
    private ImageView login_image_2;

    @FXML
    private TextField username_1;
    @FXML
    private TextField username_2;
    @FXML
    private Button continue_button;

    @FXML
    public void handle(ActionEvent event) throws IOException {
        player1_error.setText("");
        player2_error.setText("");
        String player1 = username_1.getText();
        String player2 = username_2.getText();
        // we want to check if fields are empty => not allowed
        if ((player1.isEmpty()) && (!player2.isEmpty())) {
            System.out.println("Empty player1");
            player1_error.setText("Empty player1");
        }
        if ((!player1.isEmpty()) && (player2.isEmpty())) {
            System.out.println("Empty player2");
            player2_error.setText("Empty player2");
        }
        if ((player1.isEmpty()) && (player2.isEmpty())) {
            System.out.println("Both are empty");
            player1_error.setText("Empty");
            player2_error.setText("Empty");
        }

        if ((!player1.isEmpty()) && (!player2.isEmpty())) {
            System.out.printf("Logged in as %s %s", player1, player2);
            successful_login.setText("Successfully logged in as " + player1 + " and " + player2);
            JavaToDatabase.writePlayerToDB(player1, player2);

            // change scene here
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("begin_buzzer.fxml"));
                root.setFocusTraversable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage window = (Stage) continue_button.getScene().getWindow(); // typecast to Stage
            window.setScene((new Scene(root)));

            window.setTitle("Let's see who's faster :)");
        }

    }

}