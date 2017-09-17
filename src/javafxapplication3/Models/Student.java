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
public class Student {
   public String firstname;
   public String lastname;
   public String studentNum;
   public String email;
   public int qualificationid;
   public int userid;
    
    public Student(String firstname, String lastname, String studentNum, String email, int qualificationid, int userid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentNum = studentNum;
        this.email = email;
        this.qualificationid = qualificationid;
        this.userid = userid;
    }
    
    
}
