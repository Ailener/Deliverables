/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXRippler.RipplerMask;
import com.jfoenix.controls.JFXRippler.RipplerPos;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Renier Coetsee
 */
public class homePageController implements Initializable {

       @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXButton exitButton;

    @FXML
    private JFXDialog loginFailed;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXTextField userField;

    @FXML
    private StackPane stackPane;
    
    JavaFXApplication3 control = new JavaFXApplication3();

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        System.out.println(userField.getText());
        System.out.println(passField.getText());
        
            Stage stage = new Stage();
            stage.setTitle("Shop Management");
            Pane myPane = null;
            Stage prevStage = (Stage) loginButton.getScene().getWindow();
      
        
        if (login(userField.getText(), passField.getText())) {
           
            myPane = FXMLLoader.load(getClass().getResource("userPage.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);

            prevStage.close();

            stage.show();
        } else {
            
            JFXDialogLayout content = new JFXDialogLayout();
            JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
            content.setBody(new Text("Login Failed"));
            JFXButton button = new JFXButton("Confirm");
            button.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event){
                   dialog.close();
               }
            });
            content.setActions(button);
            
            dialog.show();
           
        }

    }

    @FXML
    private void exitProgram(ActionEvent event) {
        Stage stage = new Stage();
        Stage thisStage = (Stage) exitButton.getScene().getWindow();
        thisStage.close();
    }
    
    public Boolean login(String username, String password){
        
        User dbUser = getUser(username);
        
        
        if(!(dbUser.user.equals("Not Found")) && !(dbUser.user.equals("An Error Occured"))){
            if(username.equals(dbUser.user) && password.equals(dbUser.pass)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
 
    
     
    
    public User getUser(String userName){
        try{
            
                System.out.println(userName);
              Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/userDb?useSSL=false", "renier", "plane123");
              Statement stmt = conn.createStatement();
              System.out.println("Here we are");
              String userSelect = "select * from users where username = '" + userName + "'";
              ResultSet gotUser = stmt.executeQuery(userSelect);
              System.out.println("Maybe?");
              if(gotUser.next()){
                  System.out.println(gotUser.getString("username") +  gotUser.getString("password"));
                  User user = new User(gotUser.getString("username"), gotUser.getString("password"));
                  return user;
              }
              else{
                 User user = new User("Not Found", "Not Found");
                 return user;
              }
              
        }
        catch(Exception e){
            e.printStackTrace();
            User user = new User("An Error Occured", "An Error Occured");
            return user;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}


   class User{
        String user;
        String pass;
        
        public User(String dbUser, String dbPass){
            this.user = dbUser;
            this.pass = dbPass;
        }
    }
    