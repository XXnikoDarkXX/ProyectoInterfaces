/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import model.Tarea;
import repositorio.BaseDatos;

/**
 *
 * @author nicoc
 */
public class GestorTareas {
    private BaseDatos baseDatos;
    
    
    public GestorTareas(BaseDatos baseDatos){
        this.baseDatos=baseDatos;
    }
    
    @FXML
    private ComboBox comboTareas;
    
      public void initialize() {
     ArrayList <Tarea> lista =new ArrayList<Tarea>();
     lista=baseDatos.todasTareas();
               comboTareas.setVisible(false);

         ObservableList listaCombo = FXCollections.observableArrayList();
         
          for (int i = 0; i < lista.size(); i++) {
             listaCombo.add(lista.get(i).getNombreTarea());
             
          }
          comboTareas.setItems(listaCombo);
               comboTareas.setVisible(true);

      }
      
}
