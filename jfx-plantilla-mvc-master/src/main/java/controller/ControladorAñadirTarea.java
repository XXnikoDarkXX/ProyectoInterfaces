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
import javafx.scene.control.MenuItem;
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
    private Pantalla navigation;

    /**
     * Controlador para añadir tareas¡
     *
     * @param tarea tarea
     * @param navigation navegacion
     * @param baseDatos base de datos
     */
    public ControladorAñadirTarea(Tarea tarea, Pantalla navigation, BaseDatos baseDatos) {
        this.tarea = tarea;

        this.navigation = navigation;
        this.baseDatos = baseDatos;

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
    @FXML
    private MenuItem itemAddTarea;
    @FXML
    private MenuItem itemVerTareas;

    public void initialize() {

        this.itemAddTarea.setOnAction(e -> {
            this.navigation.Navigate(ScreenEnum.AñadirTareas);
        });

        this.itemVerTareas.setOnAction(e -> {
            this.navigation.Navigate(ScreenEnum.GestorTareas);

        });

        /**
         * Al pulsar el boton de añadir Tarea tendremos que comprobar que los
         * campos esten completos si no nos dara falso y no podremos añadir la
         * tarea+
         */
        btnTarea.setOnAction((actionEvent) -> {
            boolean comprobacion = false;
            if ((txtContenido.getText().equals("") || txtTitulo.getText().equals("") || fTarea.getValue() == null || txtContenido.getText().equals(""))) {
                comprobacion = false;

            } else {
                comprobacion = true;
            }
            if (comprobacion) {
                Tarea tareados = new Tarea();
                tareados.setNombreTarea(txtTitulo.getText());
                tareados.setFechaTarea(fTarea.getValue().toString());
                tareados.setContenidoTarea(txtContenido.getText());
                tarea = tareados;
                baseDatos.AñadirTarea(tarea);

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

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestor de Tareas");
            alert.setHeaderText(null);
            alert.setContentText("Vamos a mostrar las tareas");

            alert.showAndWait();
            this.navigation.Navigate(ScreenEnum.GestorTareas);

        });

    }

    public void closeWindows() {

    }

}
