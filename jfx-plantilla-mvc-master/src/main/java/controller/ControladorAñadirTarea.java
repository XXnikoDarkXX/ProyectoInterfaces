/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Tarea;

/**
 *
 * @author nicoc
 */
public class ControladorAñadirTarea {
    Tarea tarea;
    
    public ControladorAñadirTarea(Tarea tarea){
        this.tarea=tarea;
    }
 //   @FXML
  //  private Button btnAñadirTarea;
  //  @FXML
 //   private TextArea txtContenido;
//    @FXML
 //   private TextField txtTitulo;
 //   @FXML
//   private DatePicker fTarea;    
   
    
    public void initialize(){
        
       /*   btnAñadirTarea.setOnAction((actionEvent) -> {
              if (!(txtContenido.getText().equals("")&&txtTitulo.getText().equals("")&&fTarea.getValue()==null)) {
                  System.out.println("hola");   
              }
          });
          *///
        
        
    }

    
    
    
   public void closeWindows(){
       
           
    }
    
   
    
}
