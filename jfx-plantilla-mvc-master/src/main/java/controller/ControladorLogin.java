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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Login;
import model.Tarea;

/**
 *
 * @author nicoc
 */
public class ControladorLogin {

    private Pantalla navigation;

    private Login login;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblLogin;
    @FXML
    private Label labelSegundo;

    /**
     * Constructor login vacio
     */
    public ControladorLogin(Login login, Pantalla navigation) {
        this.login = login;
        this.navigation = navigation;

    }

    public void initialize() {
        //Aqui uso biding
        labelSegundo.textProperty().bind(txtUsuario.textProperty());//En el label segundo mediante el textProperty
        //le metemos el usuario que escribamos en el txtUsuario (campo del usuario)

        btnLogin.setOnAction((actionEvent) -> {
            login.setUsername(txtUsuario.getText());
            login.setPassword(txtPassword.getText());
            //Si ponemos 
            lblLogin = new Label();

            if (login.getUsername().equals("admin") && login.getPassword().equals("admin")) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Gestor de Tareas");
                alert.setHeaderText(null);
                alert.setContentText("Te has logueado");

                alert.showAndWait();
                this.navigation.Navigate(ScreenEnum.AñadirTareas);

            } else {
                lblLogin.setText("Error!!");
            }
        });
    }

}
