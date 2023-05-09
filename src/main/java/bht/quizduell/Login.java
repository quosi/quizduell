package bht.quizduell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public class Login {

    public Login(){
    }

    @FXML
    private Label feedbackLabel;
    @FXML
    private Button start;
    @FXML
    private TextField name1;
    @FXML
    private TextField name2;

    public void userLogin(ActionEvent event)throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        if (name1.getText().toString().isEmpty() && name2.getText().toString().isEmpty()) {
            feedbackLabel.setText("Enter two names to start.");}

        else if (name1.getText().equals(name2.getText())) {
            feedbackLabel.setText("Enter two different names!");}

        else if((!name1.getText().toString().isEmpty()) && (!name2.getText().toString().isEmpty())) {
            feedbackLabel.setText("Success!");
            m.changeScene("landingPage.fxml");}

        else {
            feedbackLabel.setText("Enter two names to start.");}
    }
}