/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nicoc
 * 
 */
public class Login {
    private String username;
    private String password;
    
    /**
     * Constructor de Login vacio
     */
    public Login(){
        
    }
       /**
        * Constructor de Login con todos los parametros
        * @param user usuario
        * @param pass contraseña
        */
    public Login(String user, String pass){
        this.username=user;
        this.password=pass;
    }
    
    /**
     *Getter de username
     * return nos devuelve el username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Getter de Password
     * @return  la contraseña
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter de username
     * @param username a cambiar
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Setter de password
     * @param password  a cambiar
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
