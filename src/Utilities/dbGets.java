/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafxapplication3.Models.*;


/**
 *
 * @author renier
 */




public class dbGets {
    
    public dbGets(){
        
    }
    
    public User getUserWithUserName(String userName){
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
                  User user = new User(gotUser.getString("username"), gotUser.getString("password"), gotUser.getInt("id"), gotUser.getInt("student"));
                  return user;
              }
              else{
                 User user = new User("Not Found", "Not Found", 0, 0);
                 return user;
              }
              
        }
        catch(Exception e){
            e.printStackTrace();
            User user = new User("An Error Occured", "An Error Occured", 0, -1);
            return user;
        }
    }
    
    
    public User getUserWithUserId(int userId){
        try{
            
              Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/userDb?useSSL=false", "renier", "plane123");
              Statement stmt = conn.createStatement();
              System.out.println("Here we are");
              String userSelect = "select * from users where id = '" + userId + "'";
              ResultSet gotUser = stmt.executeQuery(userSelect);
              System.out.println("Maybe?");
              if(gotUser.next()){
                  System.out.println(gotUser.getString("username") +  gotUser.getString("password"));
                  User user = new User(gotUser.getString("username"), gotUser.getString("password"), gotUser.getInt("id"), gotUser.getInt("student"));
                  return user;
              }
              else{
                 User user = new User("Not Found", "Not Found", 0, 0);
                 return user;
              }
              
        }
        catch(Exception e){
            e.printStackTrace();
            User user = new User("An Error Occured", "An Error Occured", 0, -1);
            return user;
        }
    }
    
    
    public Student getStudentWithUserId(int userId){
        try{
            
              Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/userDb?useSSL=false", "renier", "plane123");
              Statement stmt = conn.createStatement();
              System.out.println("Here we are");
              String userSelect = "select * from students where userid = " + userId + "";
              ResultSet gotStudent = stmt.executeQuery(userSelect);
              System.out.println("Maybe?");
              if(gotStudent.next()){
                  Student student = new Student(gotStudent.getString("firstname"), gotStudent.getString("lastname"), gotStudent.getString("studentNum"), gotStudent.getString("email"), gotStudent.getInt("qualificationid"), gotStudent.getInt("userid"));
                  return student;
              }
              else{
                 Student student = new Student("Not Found", "Not Found", "" , "",  0, 0);
                 return student;
              }
              
        }
        catch(Exception e){
            e.printStackTrace();
            Student student = new Student("Not Found", "Not Found", "" , "",  0, 0);
            return student;
        }
    }
}

