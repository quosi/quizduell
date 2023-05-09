package bht.quizduell;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LandingPage {

    public LandingPage(){
    }

    @FXML
    private Button restart;
    @FXML
    private Button questions;
    @FXML
    private Label showname1;
    @FXML
    private Label showname2;
    public void userRestart(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
    public void goToQuestions(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("questionPage.fxml");
    }


    public void checkUserInput(KeyEvent event)throws IOException {
        checkKeys();
    }
    private void checkKeys() throws IOException {
        Main m = new Main();

        System.out.println("PRINT KEY");
        //m.changeScene("questionPage.fxml");
    }

}
