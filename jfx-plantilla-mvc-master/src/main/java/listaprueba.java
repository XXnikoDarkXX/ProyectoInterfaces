
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Tarea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicoc
 */
public class listaprueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
HashMap<String,Tarea> listaTareas=new HashMap<String,Tarea>();

Tarea tarea1=new Tarea("Tarea1","contenido1","fecha1");
Tarea tarea2=new Tarea("Tarea2","contenido2","fecha2");
Tarea tarea3=new Tarea("Tarea3","contenido3","fecha3");
listaTareas.put(tarea1.getNombreTarea(), tarea1);
listaTareas.put(tarea2.getNombreTarea(), tarea2);
listaTareas.put(tarea3.getNombreTarea(), tarea3);


       /* for (int i = 0; i < lista.size(); i++) {
            
            System.out.println(lista.get(i).getNombreTarea());
        }^*/

    }
    
}
