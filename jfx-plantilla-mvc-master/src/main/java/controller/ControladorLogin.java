/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Login;
import model.Tarea;

/**
 *
 * @author nicoc
 */
public class ControladorLogin {

    private Login login;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblLogin;

    /**
     * Constructor login vacio
     */
    public ControladorLogin(Login login) {
        this.login = login;

    }

    public void initialize() {
        btnLogin.setOnAction((actionEvent) -> {
            login.setUsername(txtUsuario.getText());
            login.setPassword(txtPassword.getText());
              //Si ponemos 
            if (login.getUsername().equals("admin") && login.getPassword().equals("admin")) {

                try {

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Gestor de Tareas");
                    alert.setHeaderText(null);
                    alert.setContentText("Te has logueado");

                    alert.showAndWait();
            
                    var fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/view/vistaTarea.fxml"));
                    var controladorTarea = new ControladorAñadirTarea(new Tarea());
                    fxmlLoader.setController(controladorTarea);
                    var root = (Pane) fxmlLoader.load();
                    var scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e -> controladorTarea.closeWindows());

                    Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else{
                lblLogin.setText("Error!!");
            }
        });
    }

}
