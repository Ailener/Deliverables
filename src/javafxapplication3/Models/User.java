/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3.Models;

/**
 *
 * @author renier
 */
 public class User{
        public String user;
        public String pass;
        public int userid;
        public int student;
        
        public User(String dbUser, String dbPass, int userid, int student){
            this.user = dbUser;
            this.pass = dbPass;
            this.userid = userid;
            this.student = student;
        }
    }