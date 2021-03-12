/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Tarea;
import repositorio.BaseDatos;

/**
 *
 * @author nicoc
 */
public class GestorTareas {

    private BaseDatos baseDatos;
    private Pantalla navigation;

    public GestorTareas(BaseDatos baseDatos, Pantalla navigation) {
        this.baseDatos = baseDatos;
        this.navigation = navigation;
    }

    @FXML
    private ComboBox comboTareas;

    @FXML
    private Button btnCargaTareas;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextArea txtContenido;

    @FXML
    private DatePicker fTarea;
    @FXML
    private MenuItem itemAddTareas;
    @FXML
    private MenuItem itemVerTareas;
    @FXML
    private Button btnTarea;

    @FXML
    private RadioButton rdActualizar;
    @FXML
    private RadioButton rdEliminar;

    private ToggleGroup gp;

    public void initialize() {
        gp = new ToggleGroup();
        rdActualizar.setToggleGroup(gp);
        rdEliminar.setToggleGroup(gp);
        this.itemAddTareas.setOnAction(eh -> {
            this.navigation.Navigate(ScreenEnum.AñadirTareas);

        });

        this.itemVerTareas.setOnAction(eh -> {
            this.navigation.Navigate(ScreenEnum.GestorTareas);
        });

        btnTarea.setOnAction((actionEvent) -> {
            if (rdActualizar.isSelected()) {
                Tarea actualizada = new Tarea(txtTitulo.getText(), txtContenido.getText(), this.fTarea.getValue().toString());
                baseDatos.actualizarTarea(actualizada);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gestor Tareas");
                    alert.setHeaderText(null);
                    alert.setContentText("Tarea Actualizada :D");

                    alert.showAndWait();
            }else if(rdEliminar.isSelected()){
         Tarea paraEliminar = new Tarea(txtTitulo.getText(), txtContenido.getText(), this.fTarea.getValue().toString());
            baseDatos.eliminarTarea(paraEliminar);
            cargarTareas();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gestor Tareas");
                    alert.setHeaderText(null);
                    alert.setContentText("Tarea Eliminada");
                    alert.showAndWait();
                    
            }
        });

        btnCargaTareas.setOnAction((actionEvent) -> {
           cargarTareas();

            comboTareas.setVisible(true);

        });

        comboTareas.setOnAction(e -> System.out.println("Action Nueva Selección: " + comboTareas.getValue()));

        comboTareas.valueProperty().addListener((ov, p1, p2) -> {
            
            String tituloTarea = p2.toString();
            Tarea tarea = new Tarea();
            tarea = baseDatos.devuelveTarea(tituloTarea);
            this.txtTitulo.setText(tarea.getNombreTarea());
            this.txtContenido.setText(tarea.getContenidoTarea());
            LocalDate fecha = LocalDate.parse(tarea.getFechaTarea());
            this.fTarea.setValue(fecha);
        });

    }

    public void setBaseDatos(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void setNavigation(Pantalla navigation) {
        this.navigation = navigation;
    }

    public void setComboTareas(ComboBox comboTareas) {
        this.comboTareas = comboTareas;
    }

    public void setBtnCargaTareas(Button btnCargaTareas) {
        this.btnCargaTareas = btnCargaTareas;
    }

    public void setTxtTitulo(TextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public void setTxtContenido(TextArea txtContenido) {
        this.txtContenido = txtContenido;
    }

    public void setfTarea(DatePicker fTarea) {
        this.fTarea = fTarea;
    }
    
    
    public void cargarTareas(){
          ArrayList<Tarea> lista = new ArrayList<Tarea>();
            lista = baseDatos.todasTareas();

            

            ObservableList listaCombo = FXCollections.observableArrayList();
                comboTareas.getItems().clear();
            for (int i = 0; i < lista.size(); i++) {
                //listaCombo.add(lista.get(i).getNombreTarea());
               
                comboTareas.getItems().add(lista.get(i).getNombreTarea());

            }
    }

}
