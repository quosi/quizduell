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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;


public class QuestionController {
    private int question_counter = 0; // variable to keep track of question count (so we do not always get the same one)
    private Boolean clicked = false;
    @FXML
    private Button load;

    @FXML
    private TextField question_field;

    @FXML
    private TextField answer_A;
    @FXML
    private TextField answer_B;
    @FXML
    private TextField answer_C;
    @FXML
    private TextField answer_D;

    private String primaryKeyQuestion;


    @FXML
    private void loadQuestionAnswer(ActionEvent event) throws IOException, SQLException {

        // set up question text field
        Vector question_vec = JavaToDatabase.getQuestion(question_counter); // result set from query

        // element at index 0 of question_vec is the qu_ID from DB
        primaryKeyQuestion = (String) question_vec.get(0);
        System.out.println(primaryKeyQuestion);

        // set TextField for question
        String qu = (String) question_vec.get(1);
        question_field.setText(qu); // typecast to string

        // set up answer text fields
        Vector answer_vec = JavaToDatabase.getAnswers(question_counter); // result set from query
        // set TextField for answer A
        String asw_a = (String) answer_vec.get(0);
        answer_A.setText(asw_a);
        // set TextField for answer B
        String asw_b = (String) answer_vec.get(1);
        answer_B.setText(asw_b);
        // set TextField for answer C
        String asw_c = (String) answer_vec.get(2);
        answer_C.setText(asw_c);
        // set TextField for answer D
        String asw_d = (String) answer_vec.get(3);
        answer_D.setText(asw_d);

        // this counter is updated after each loaded question
        // => serves to keep track of current qu_ID in database
        question_counter +=1;


    }

    // if answer A is clicked
    @FXML
    private void AClicked(MouseEvent event) {
        if (clicked == false) {
            clicked = true;
            System.out.println(("Clicked A"));
            // get text from field
            String txt_a = answer_A.getText();
            //System.out.println(txt_a);
            // then get primaryKeyQuestion variable bc it contains primary key of question in DB
            //primaryKeyQuestion = String.valueOf(Integer.getInteger(primaryKeyQuestion));
            Boolean answerStatus = JavaToDatabase.answerTrueFalse(txt_a, Integer.parseInt(primaryKeyQuestion));
            if (answerStatus == true) {
                answer_A.setStyle("-fx-background-color: #70db70");
                answer_A.setDisable(false);

            } else {
                answer_A.setStyle("-fx-background-color: #ff5c33");
                answer_A.setDisable(true);
            }
        }
    }

    // if answer B is clicked
    @FXML
    private void BClicked(MouseEvent event) {
        if (clicked == false) {
            clicked = true;
            System.out.println(("Clicked B"));
            // get text from field
            String txt_b = answer_B.getText();
            // then get primaryKeyQuestion variable bc it contains primary key of question in DB
            Boolean answerStatus = JavaToDatabase.answerTrueFalse(txt_b, Integer.parseInt(primaryKeyQuestion));
            if (answerStatus == true) {
                answer_B.setStyle("-fx-background-color: #70db70");
            } else {
                answer_B.setStyle("-fx-background-color: #ff5c33");
            }
        }
    }

    // if answer C is clicked
    @FXML
    private void CClicked(MouseEvent event) {
        if (clicked == false) {
            clicked = true;
            System.out.println(("Clicked C"));
            String txt_c = answer_C.getText();
            // then get primaryKeyQuestion variable bc it contains primary key of question in DB
            Boolean answerStatus = JavaToDatabase.answerTrueFalse(txt_c, Integer.parseInt(primaryKeyQuestion));
            if (answerStatus == true) {
                answer_C.setStyle("-fx-background-color: #70db70");
            } else {
                answer_C.setStyle("-fx-background-color: #ff5c33");
            }
        }
    }

    // if answer D is clicked
    @FXML
    private void DClicked(MouseEvent event) {
        if (clicked == false) {
            clicked = true;
            System.out.println(("Clicked D"));
            String txt_d = answer_D.getText();
            // then get primaryKeyQuestion variable bc it contains primary key of question in DB
            Boolean answerStatus = JavaToDatabase.answerTrueFalse(txt_d, Integer.parseInt(primaryKeyQuestion));
            if (answerStatus == true) {
                answer_D.setStyle("-fx-background-color: #70db70");
            } else {
                answer_D.setStyle("-fx-background-color: #ff5c33");

            }
        }
    }
}
