/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.Serializable;

/**
 *
 * @author Minhal
 */
public class Account implements Serializable {
    
    protected String userName;
    protected String emailAddress;
    protected String emailPassword;
    
    
    public Account(String a, String p){
        emailAddress = a;
        emailPassword = p;
    }
    
    public Account(String u, String a, String p){
        userName = u;
        emailAddress = a;
        emailPassword = p;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public String toString(){
        return "UserName: " + userName + " | EmailAddress: " + emailAddress;
    }
    
}
