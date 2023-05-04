package bht.quizduell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;


public class Login {

    public Login(){
    }

    @FXML
    private Label feedbackLabel;
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event)throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if((username.getText().toString().equals("JavaRocks")) && (password.getText().toString().equals("123"))) {
            feedbackLabel.setText("Success!");
            m.changeScene("afterLogin.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            feedbackLabel.setText("Enter your login data.");
        }
        else {
            feedbackLabel.setText("Wrong user or password!");
        }
    }

}