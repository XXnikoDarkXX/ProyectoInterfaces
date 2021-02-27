/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import model.Tarea;

/**
 *
 * @author nicoc
 */
public class BaseDatos {

    private HashMap<String, Tarea> listaTareas;

    /**
     * Consltructor de BaseDatos vacio
     */
    public BaseDatos() {
        listaTareas = new HashMap<String, Tarea>();
    }
    /**
     * Funcion que nos devuelve la tarea segun el titulo de dicha tarea
     *
     * @param titulo nombre de la tarea
     * @return la tarea buscada por titulo si existe
     */
    public Tarea devuelveTarea(String titulo) {
        Tarea tarea = null;
        for (Entry<String, Tarea> entry : listaTareas.entrySet()) {
            if (entry.getKey().equals(titulo)) {
                tarea = entry.getValue();
            }

        }
        return tarea;

    }
    /**
     * Funcion para añadir tarea
     *
     * @param tarea que vamos a añadir a la base de datos
     */
    public void AñadirTarea(Tarea tarea) {
        listaTareas.put(tarea.getNombreTarea(), tarea);
    }

    /**
     * Funcion para eliminar tarea
     *
     * @param tarea la cual vamos a eliminar
     */
    public void eliminarTarea(Tarea tarea) {

        listaTareas.remove(tarea.getNombreTarea());

    }
    /**
     * Funcion para actualizar la tarea de la bbdd elegida
     *
     * @param tarea que tenemos actualizada
     */
    public void actualizarTarea(Tarea tarea) {

        for (Entry<String, Tarea> entry : listaTareas.entrySet()) {
            if (entry.getKey().equals(tarea.getNombreTarea())) {
                entry.setValue(tarea);

            }

        }
    }
    /**
     * Funcion donde nos devuelve todas las tareas de la bbdd
     * @return todas las tareas en un ArrayList
     */
    public ArrayList<Tarea> todasTareas() {
        ArrayList<Tarea> lista = new ArrayList<Tarea>();
        for (Entry<String, Tarea> entry : listaTareas.entrySet()) {
            lista.add(entry.getValue());
        }
        return lista;
    }
    
}
