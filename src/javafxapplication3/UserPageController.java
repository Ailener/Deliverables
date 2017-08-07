/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Renier Coetsee
 */
public class UserPageController implements Initializable {

      @FXML
    private Label label;
      
      @FXML
      private Button exitButton;
    
    @FXML
    private void exitProgram(ActionEvent event) {
        Stage stage = new Stage();
        Stage thisStage = (Stage) exitButton.getScene().getWindow();
        thisStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

