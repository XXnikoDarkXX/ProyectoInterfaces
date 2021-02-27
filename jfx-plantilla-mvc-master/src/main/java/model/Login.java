/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nicoc
 */
public class Login {
    private String username;
    private String password;
    
    
    public Login(){
        
    }
    
    public Login(String user, String pass){
        this.username=user;
        this.password=pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
