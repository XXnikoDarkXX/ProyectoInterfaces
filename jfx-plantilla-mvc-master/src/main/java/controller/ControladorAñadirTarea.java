/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Tarea;
import repositorio.BaseDatos;

/**
 *
 * @author nicoc
 */
public class ControladorAñadirTarea {

    Tarea tarea;
    private BaseDatos baseDatos;

    public ControladorAñadirTarea(Tarea tarea) {
        this.tarea = tarea;
        this.baseDatos = new BaseDatos();

    }
    @FXML
    private Button btnTarea;
    @FXML
    private TextArea txtContenido;
    @FXML
    private TextField txtTitulo;
    @FXML
    private DatePicker fTarea;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button irGestorTareas;
    public void initialize() {
    
            /**
             * Al pulsar el boton de añadir Tarea tendremos que comprobar que los campos esten completos si no nos dara falso
             * y no podremos añadir la tarea+
             */
        btnTarea.setOnAction((actionEvent) -> {
            boolean comprobacion = false;
            if ((txtContenido.getText().equals("") || txtTitulo.getText().equals("") || fTarea.getValue() == null || txtContenido.getText().equals(""))) {
                comprobacion = false;

            } else {

                comprobacion = true;
            }

            if (comprobacion) {

                tarea.setNombreTarea(txtTitulo.getText());
                tarea.setFechaTarea(fTarea.getValue().toString());
                tarea.setContenidoTarea(txtContenido.getText());
                baseDatos.AñadirTarea(tarea);
                System.out.println("hola");
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gestor de Tareas");
                    alert.setHeaderText(null);
                    alert.setContentText("Tarea Añadida");
                    alert.showAndWait();
            }
        });
           //Limpiamos todos los campos
        btnBorrar.setOnAction((actionEvent) -> {
            txtContenido.setText("");
            txtTitulo.setText("");
            fTarea.setValue(null);

        });

          irGestorTareas.setOnAction((actionEvent) -> {
            try {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gestor de Tareas");
                    alert.setHeaderText(null);
                    alert.setContentText("Vamos a mostrar las tareas");

                    alert.showAndWait();
            
                    var fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/view/gestorTareas.fxml"));
                    var gestorTareas = new GestorTareas(this.baseDatos);
                    fxmlLoader.setController(gestorTareas);
                    var root = (Pane) fxmlLoader.load();
                    var scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
              //      stage.setOnCloseRequest(e -> controladorTarea.closeWindows());

                    Stage myStage = (Stage) this.btnBorrar.getScene().getWindow();
                    myStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            
          });
        
    }

    public void closeWindows() {

    }

}
