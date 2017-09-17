/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import Utilities.dbGets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxapplication3.Models.Student;
import javafxapplication3.Models.User;

/**
 * FXML Controller class
 *
 * @author Renier Coetsee
 */
public class UserPageController implements Initializable {

    int userid;
    Boolean isStudent;
    Student student;

    dbGets utiGets = new dbGets();

    @FXML
    private Text label;

    @FXML
    private Button exitButton;

    @FXML
    private void exitProgram(ActionEvent event) {
        Stage stage = new Stage();
        Stage thisStage = (Stage) exitButton.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    public void openScreen(int id, Boolean studentBool) {
        Stage stage = new Stage();
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("userPage.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            userid = id;
            isStudent = studentBool;
            stage.show();
            if (isStudent) {
                student = utiGets.getStudentWithUserId(userid);
                label.setText("Welcome " + student.firstname + " " + student.lastname + ". Here are your subjects for the day.");
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
